/*
 *Copyright (c) 2019, WSO2 Inc. (http://www.wso2.org) All Rights Reserved.
 *
 *WSO2 Inc. licenses this file to you under the Apache License,
 *Version 2.0 (the "License"); you may not use this file except
 *in compliance with the License.
 *You may obtain a copy of the License at
 *
 *http://www.apache.org/licenses/LICENSE-2.0
 *
 *Unless required by applicable law or agreed to in writing,
 *software distributed under the License is distributed on an
 *"AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 *KIND, either express or implied.  See the License for the
 *specific language governing permissions and limitations
 *under the License.
 */

package org.wso2.am.scenario.tests.api.secure.userRoles;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.json.JSONArray;
import org.json.JSONObject;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.wso2.am.integration.test.utils.APIManagerIntegrationTestException;
import org.wso2.am.integration.test.utils.base.APIMIntegrationConstants;
import org.wso2.am.integration.test.utils.bean.APILifeCycleState;
import org.wso2.am.integration.test.utils.bean.APPKeyRequestGenerator;
import org.wso2.am.scenario.test.common.APIPublisherRestClient;
import org.wso2.am.scenario.test.common.APIRequest;
import org.wso2.am.scenario.test.common.APIStoreRestClient;
import org.wso2.am.scenario.test.common.HttpClient;
import org.wso2.am.scenario.test.common.ScenarioDataProvider;
import org.wso2.am.scenario.test.common.ScenarioTestBase;
import org.wso2.carbon.apimgt.api.APIManagementException;
import org.wso2.carbon.automation.test.utils.http.client.HttpResponse;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertNotNull;

public class SecureUsingUserRolesTestCases extends ScenarioTestBase {

    private APIStoreRestClient apiStore;
    private APIPublisherRestClient apiPublisher;
    private List<String> applicationsList = new ArrayList<>();
    private static final Log log = LogFactory.getLog(SecureUsingUserRolesTestCases.class);
    private static final String ADMIN_LOGIN_USERNAME = "admin";
    private static final String ADMIN_LOGIN_PW = "admin";
    private static final String LOGIN_PERMISSION = "/permission/admin/login";
    private static final String API_ADMIN_PERMISSION = "/permission/admin";
    private static final String API_PUBLISHER_PERMISSION = "/permission/admin/manage/api/publish";
    private static final String API_CREATOR_PERMISSION = "/permission/admin/manage/api/create";
    private static final String MANAGER_ROLE = "managerRole";
    private static final String MANAGER_LOGIN_PW = "manager";
    private static final String AGENT_ROLE = "agentRole";
    private static final String AGENT_LOGIN_PW = "agent";
    private static final String CUSTOMER_ROLE = "customerRole";
    private static final String CUSTOMER_LOGIN_PW = "customer";
    private static final String MANAGER = "Alex";
    private static final String AGENT = "Paul";
    private static final String CUSTOMER = "Rick";
    private static final String SUPER_USER = "Harry";
    private static final String SUPER_USER_LOGIN_PW = "super";
    private static final String ITEM_VIEW = "item_view";
    private static final String ITEM_ADD = "item_add";
    private static final String ORDER_VIEW = "order_view";
    private static final String ORDER_ADD = "order_add";
    private static final String SCOPE_EXISTANCE = "isScopeExist";
    private static final String ROLE_EXISTANCE = "isRoleExist";

    List<String> userList = new ArrayList();
    List<String> roleList = new ArrayList();

    @DataProvider(name = "ScopeAndValidRoleDataProvider")
    public static Object[][] ValidRoleDataProvider() {

        return new Object[][]{
                {MANAGER_ROLE, ITEM_ADD},
                {AGENT_ROLE, ORDER_ADD},
                {CUSTOMER_ROLE, ORDER_VIEW}
        };
    }

    private void setupUserData() {

        try {
            createRoles();
            createUsers();
        } catch (APIManagementException ex) {
            log.error("Users or roles creation failed.", ex);
        }
    }

    private void createRoles() throws APIManagementException {

        createRole(ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW, MANAGER_ROLE, new String[]{API_ADMIN_PERMISSION});
        roleList.add(MANAGER_ROLE);
        createRole(ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW, AGENT_ROLE, new String[]{API_PUBLISHER_PERMISSION,
                API_CREATOR_PERMISSION});
        roleList.add(AGENT_ROLE);
        createRole(ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW, CUSTOMER_ROLE, new String[]{LOGIN_PERMISSION});
        roleList.add(CUSTOMER_ROLE);
    }

    private void createUsers() throws APIManagementException {

        createUser(MANAGER, MANAGER_LOGIN_PW, new String[]{MANAGER_ROLE}, ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW);
        userList.add(MANAGER);
        createUser(AGENT, AGENT_LOGIN_PW, new String[]{AGENT_ROLE}, ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW);
        userList.add(AGENT);
        createUser(CUSTOMER, CUSTOMER_LOGIN_PW, new String[]{CUSTOMER_ROLE}, ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW);
        userList.add(CUSTOMER);
        createUser(SUPER_USER, SUPER_USER_LOGIN_PW, new String[]{MANAGER_ROLE, AGENT_ROLE}, ADMIN_LOGIN_USERNAME,
                ADMIN_LOGIN_PW);
        userList.add(SUPER_USER);
    }

    private void deleteUsers() throws APIManagementException {

        if (userList.size() > 0) {
            for (String username : userList) {
                deleteUser(username, ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW);
            }
        }
    }

    private void deleteRoles() throws APIManagementException {

        if (roleList.size() > 0) {
            for (String role : roleList) {
                deleteRole(role, ADMIN_LOGIN_USERNAME, ADMIN_LOGIN_PW);
            }
        }
    }

    @BeforeClass(alwaysRun = true)
    public void init() throws APIManagerIntegrationTestException, APIManagementException {

        setupUserData();
        apiStore = new APIStoreRestClient(storeURL);
        apiStore.login(SUPER_USER, SUPER_USER_LOGIN_PW);
        apiPublisher = new APIPublisherRestClient(publisherURL);
        apiPublisher.login(SUPER_USER, SUPER_USER_LOGIN_PW);

    }

    @Test(description = "3.2.1.1", dataProvider = "ScopeAndValidRoleDataProvider",
            dataProviderClass = SecureUsingUserRolesTestCases.class)
    public void testScopeCreationWithValidValues(String role, String scope) throws Exception {

        HttpResponse httpResponse = apiPublisher.validateScope(scope, role);
        verifyResponse(httpResponse);
        assertEquals(new JSONObject(httpResponse.getData()).get(SCOPE_EXISTANCE).toString(), "false",
                "Error in scope creation with valid values. Scope  : " + scope);
        assertEquals(new JSONObject(httpResponse.getData()).get(ROLE_EXISTANCE).toString(), "true",
                "Error in scope creation with valid values. Role  : " + role);

    }

    @AfterClass(alwaysRun = true)
    public void destroy() throws APIManagerIntegrationTestException {

        for (String name : applicationsList) {
            apiStore.removeApplication(name);
        }
        applicationsList.clear();
        try {
            deleteUsers();
            deleteRoles();
        } catch (APIManagementException ex) {
            log.error("Users or role deletion failed", ex);
        }
    }
}
