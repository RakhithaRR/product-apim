/*
 * WSO2 API Manager - Store
 * This document specifies a **RESTful API** for WSO2 **API Manager** - Store.  It is written with [swagger 2](http://swagger.io/). 
 *
 * OpenAPI spec version: v1.0
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.store.api.v1;

import org.wso2.am.integration.clients.store.api.ApiCallback;
import org.wso2.am.integration.clients.store.api.ApiClient;
import org.wso2.am.integration.clients.store.api.ApiException;
import org.wso2.am.integration.clients.store.api.ApiResponse;
import org.wso2.am.integration.clients.store.api.Configuration;
import org.wso2.am.integration.clients.store.api.Pair;
import org.wso2.am.integration.clients.store.api.ProgressRequestBody;
import org.wso2.am.integration.clients.store.api.ProgressResponseBody;

import com.google.gson.reflect.TypeToken;

import java.io.IOException;


import org.wso2.am.integration.clients.store.api.v1.dto.AlertConfigDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.AlertConfigInfoDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.AlertConfigListDTO;
import org.wso2.am.integration.clients.store.api.v1.dto.ErrorDTO;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AlertConfigurationApi {
    private ApiClient apiClient;

    public AlertConfigurationApi() {
        this(Configuration.getDefaultApiClient());
    }

    public AlertConfigurationApi(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    public ApiClient getApiClient() {
        return apiClient;
    }

    public void setApiClient(ApiClient apiClient) {
        this.apiClient = apiClient;
    }

    /**
     * Build call for addAlertConfig
     * @param alertType The alert type.  (required)
     * @param configurationId The alert configuration id.  (required)
     * @param body Configuration for AbnormalRequestCount alert type (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call addAlertConfigCall(String alertType, String configurationId, AlertConfigInfoDTO body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = body;

        // create path and map variables
        String localVarPath = "/alerts/{alertType}/configurations/{configurationId}"
            .replaceAll("\\{" + "alertType" + "\\}", apiClient.escapeString(alertType.toString()))
            .replaceAll("\\{" + "configurationId" + "\\}", apiClient.escapeString(configurationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "OAuth2Security" };
        return apiClient.buildCall(localVarPath, "PUT", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call addAlertConfigValidateBeforeCall(String alertType, String configurationId, AlertConfigInfoDTO body, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'alertType' is set
        if (alertType == null) {
            throw new ApiException("Missing the required parameter 'alertType' when calling addAlertConfig(Async)");
        }
        
        // verify the required parameter 'configurationId' is set
        if (configurationId == null) {
            throw new ApiException("Missing the required parameter 'configurationId' when calling addAlertConfig(Async)");
        }
        
        // verify the required parameter 'body' is set
        if (body == null) {
            throw new ApiException("Missing the required parameter 'body' when calling addAlertConfig(Async)");
        }
        

        com.squareup.okhttp.Call call = addAlertConfigCall(alertType, configurationId, body, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Add AbnormalRequestsPerMin alert configurations. 
     * This operation is used to add configuration for the AbnormalRequestsPerMin alert type. 
     * @param alertType The alert type.  (required)
     * @param configurationId The alert configuration id.  (required)
     * @param body Configuration for AbnormalRequestCount alert type (required)
     * @return AlertConfigDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AlertConfigDTO addAlertConfig(String alertType, String configurationId, AlertConfigInfoDTO body) throws ApiException {
        ApiResponse<AlertConfigDTO> resp = addAlertConfigWithHttpInfo(alertType, configurationId, body);
        return resp.getData();
    }

    /**
     * Add AbnormalRequestsPerMin alert configurations. 
     * This operation is used to add configuration for the AbnormalRequestsPerMin alert type. 
     * @param alertType The alert type.  (required)
     * @param configurationId The alert configuration id.  (required)
     * @param body Configuration for AbnormalRequestCount alert type (required)
     * @return ApiResponse&lt;AlertConfigDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AlertConfigDTO> addAlertConfigWithHttpInfo(String alertType, String configurationId, AlertConfigInfoDTO body) throws ApiException {
        com.squareup.okhttp.Call call = addAlertConfigValidateBeforeCall(alertType, configurationId, body, null, null);
        Type localVarReturnType = new TypeToken<AlertConfigDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Add AbnormalRequestsPerMin alert configurations.  (asynchronously)
     * This operation is used to add configuration for the AbnormalRequestsPerMin alert type. 
     * @param alertType The alert type.  (required)
     * @param configurationId The alert configuration id.  (required)
     * @param body Configuration for AbnormalRequestCount alert type (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call addAlertConfigAsync(String alertType, String configurationId, AlertConfigInfoDTO body, final ApiCallback<AlertConfigDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = addAlertConfigValidateBeforeCall(alertType, configurationId, body, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AlertConfigDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
    /**
     * Build call for deleteAlertConfig
     * @param alertType The alert type.  (required)
     * @param configurationId The alert configuration id.  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call deleteAlertConfigCall(String alertType, String configurationId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/alerts/{alertType}/configurations/{configurationId}"
            .replaceAll("\\{" + "alertType" + "\\}", apiClient.escapeString(alertType.toString()))
            .replaceAll("\\{" + "configurationId" + "\\}", apiClient.escapeString(configurationId.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "OAuth2Security" };
        return apiClient.buildCall(localVarPath, "DELETE", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call deleteAlertConfigValidateBeforeCall(String alertType, String configurationId, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'alertType' is set
        if (alertType == null) {
            throw new ApiException("Missing the required parameter 'alertType' when calling deleteAlertConfig(Async)");
        }
        
        // verify the required parameter 'configurationId' is set
        if (configurationId == null) {
            throw new ApiException("Missing the required parameter 'configurationId' when calling deleteAlertConfig(Async)");
        }
        

        com.squareup.okhttp.Call call = deleteAlertConfigCall(alertType, configurationId, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Delete the selected configuration from AbnormalRequestsPerMin alert type. 
     * This operation is used to delete configuration from the AbnormalRequestsPerMin alert type. 
     * @param alertType The alert type.  (required)
     * @param configurationId The alert configuration id.  (required)
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public void deleteAlertConfig(String alertType, String configurationId) throws ApiException {
        deleteAlertConfigWithHttpInfo(alertType, configurationId);
    }

    /**
     * Delete the selected configuration from AbnormalRequestsPerMin alert type. 
     * This operation is used to delete configuration from the AbnormalRequestsPerMin alert type. 
     * @param alertType The alert type.  (required)
     * @param configurationId The alert configuration id.  (required)
     * @return ApiResponse&lt;Void&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<Void> deleteAlertConfigWithHttpInfo(String alertType, String configurationId) throws ApiException {
        com.squareup.okhttp.Call call = deleteAlertConfigValidateBeforeCall(alertType, configurationId, null, null);
        return apiClient.execute(call);
    }

    /**
     * Delete the selected configuration from AbnormalRequestsPerMin alert type.  (asynchronously)
     * This operation is used to delete configuration from the AbnormalRequestsPerMin alert type. 
     * @param alertType The alert type.  (required)
     * @param configurationId The alert configuration id.  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call deleteAlertConfigAsync(String alertType, String configurationId, final ApiCallback<Void> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = deleteAlertConfigValidateBeforeCall(alertType, configurationId, progressListener, progressRequestListener);
        apiClient.executeAsync(call, callback);
        return call;
    }
    /**
     * Build call for getAllAlertConfigs
     * @param alertType The alert type.  (required)
     * @param progressListener Progress listener
     * @param progressRequestListener Progress request listener
     * @return Call to execute
     * @throws ApiException If fail to serialize the request body object
     */
    public com.squareup.okhttp.Call getAllAlertConfigsCall(String alertType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        Object localVarPostBody = null;

        // create path and map variables
        String localVarPath = "/alerts/{alertType}/configurations"
            .replaceAll("\\{" + "alertType" + "\\}", apiClient.escapeString(alertType.toString()));

        List<Pair> localVarQueryParams = new ArrayList<Pair>();
        List<Pair> localVarCollectionQueryParams = new ArrayList<Pair>();

        Map<String, String> localVarHeaderParams = new HashMap<String, String>();

        Map<String, Object> localVarFormParams = new HashMap<String, Object>();

        final String[] localVarAccepts = {
            "application/json"
        };
        final String localVarAccept = apiClient.selectHeaderAccept(localVarAccepts);
        if (localVarAccept != null) localVarHeaderParams.put("Accept", localVarAccept);

        final String[] localVarContentTypes = {
            "application/json"
        };
        final String localVarContentType = apiClient.selectHeaderContentType(localVarContentTypes);
        localVarHeaderParams.put("Content-Type", localVarContentType);

        if(progressListener != null) {
            apiClient.getHttpClient().networkInterceptors().add(new com.squareup.okhttp.Interceptor() {
                @Override
                public com.squareup.okhttp.Response intercept(com.squareup.okhttp.Interceptor.Chain chain) throws IOException {
                    com.squareup.okhttp.Response originalResponse = chain.proceed(chain.request());
                    return originalResponse.newBuilder()
                    .body(new ProgressResponseBody(originalResponse.body(), progressListener))
                    .build();
                }
            });
        }

        String[] localVarAuthNames = new String[] { "OAuth2Security" };
        return apiClient.buildCall(localVarPath, "GET", localVarQueryParams, localVarCollectionQueryParams, localVarPostBody, localVarHeaderParams, localVarFormParams, localVarAuthNames, progressRequestListener);
    }

    @SuppressWarnings("rawtypes")
    private com.squareup.okhttp.Call getAllAlertConfigsValidateBeforeCall(String alertType, final ProgressResponseBody.ProgressListener progressListener, final ProgressRequestBody.ProgressRequestListener progressRequestListener) throws ApiException {
        
        // verify the required parameter 'alertType' is set
        if (alertType == null) {
            throw new ApiException("Missing the required parameter 'alertType' when calling getAllAlertConfigs(Async)");
        }
        

        com.squareup.okhttp.Call call = getAllAlertConfigsCall(alertType, progressListener, progressRequestListener);
        return call;

    }

    /**
     * Get all AbnormalRequestsPerMin alert configurations 
     * This operation is used to get all configurations of the AbnormalRequestsPerMin alert type. 
     * @param alertType The alert type.  (required)
     * @return AlertConfigListDTO
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public AlertConfigListDTO getAllAlertConfigs(String alertType) throws ApiException {
        ApiResponse<AlertConfigListDTO> resp = getAllAlertConfigsWithHttpInfo(alertType);
        return resp.getData();
    }

    /**
     * Get all AbnormalRequestsPerMin alert configurations 
     * This operation is used to get all configurations of the AbnormalRequestsPerMin alert type. 
     * @param alertType The alert type.  (required)
     * @return ApiResponse&lt;AlertConfigListDTO&gt;
     * @throws ApiException If fail to call the API, e.g. server error or cannot deserialize the response body
     */
    public ApiResponse<AlertConfigListDTO> getAllAlertConfigsWithHttpInfo(String alertType) throws ApiException {
        com.squareup.okhttp.Call call = getAllAlertConfigsValidateBeforeCall(alertType, null, null);
        Type localVarReturnType = new TypeToken<AlertConfigListDTO>(){}.getType();
        return apiClient.execute(call, localVarReturnType);
    }

    /**
     * Get all AbnormalRequestsPerMin alert configurations  (asynchronously)
     * This operation is used to get all configurations of the AbnormalRequestsPerMin alert type. 
     * @param alertType The alert type.  (required)
     * @param callback The callback to be executed when the API call finishes
     * @return The request call
     * @throws ApiException If fail to process the API call, e.g. serializing the request body object
     */
    public com.squareup.okhttp.Call getAllAlertConfigsAsync(String alertType, final ApiCallback<AlertConfigListDTO> callback) throws ApiException {

        ProgressResponseBody.ProgressListener progressListener = null;
        ProgressRequestBody.ProgressRequestListener progressRequestListener = null;

        if (callback != null) {
            progressListener = new ProgressResponseBody.ProgressListener() {
                @Override
                public void update(long bytesRead, long contentLength, boolean done) {
                    callback.onDownloadProgress(bytesRead, contentLength, done);
                }
            };

            progressRequestListener = new ProgressRequestBody.ProgressRequestListener() {
                @Override
                public void onRequestProgress(long bytesWritten, long contentLength, boolean done) {
                    callback.onUploadProgress(bytesWritten, contentLength, done);
                }
            };
        }

        com.squareup.okhttp.Call call = getAllAlertConfigsValidateBeforeCall(alertType, progressListener, progressRequestListener);
        Type localVarReturnType = new TypeToken<AlertConfigListDTO>(){}.getType();
        apiClient.executeAsync(call, localVarReturnType, callback);
        return call;
    }
}
