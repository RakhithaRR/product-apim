/*
 * WSO2 API Manager - Publisher API
 * This specifies a **RESTful API** for WSO2 **API Manager** - Publisher.  Please see [full swagger definition](https://raw.githubusercontent.com/wso2/carbon-apimgt/v6.0.4/components/apimgt/org.wso2.carbon.apimgt.rest.api.publisher/src/main/resources/publisher-api.yaml) of the API which is written using [swagger 2.0](http://swagger.io/) specification. 
 *
 * OpenAPI spec version: v1.1
 * Contact: architecture@wso2.com
 *
 * NOTE: This class is auto generated by the swagger code generator program.
 * https://github.com/swagger-api/swagger-codegen.git
 * Do not edit the class manually.
 */


package org.wso2.am.integration.clients.publisher.api.v1.dto;

import java.util.Objects;
import java.util.Arrays;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import java.io.IOException;

/**
 * EnvironmentEndpointsDTO
 */

public class EnvironmentEndpointsDTO {
  @SerializedName("http")
  private String http = null;

  @SerializedName("https")
  private String https = null;

  @SerializedName("ws")
  private String ws = null;

  @SerializedName("wss")
  private String wss = null;

  public EnvironmentEndpointsDTO http(String http) {
    this.http = http;
    return this;
  }

   /**
   * HTTP environment URL
   * @return http
  **/
  @ApiModelProperty(example = "http://localhost:8280", value = "HTTP environment URL")
  public String getHttp() {
    return http;
  }

  public void setHttp(String http) {
    this.http = http;
  }

  public EnvironmentEndpointsDTO https(String https) {
    this.https = https;
    return this;
  }

   /**
   * HTTPS environment URL
   * @return https
  **/
  @ApiModelProperty(example = "https://localhost:8243", value = "HTTPS environment URL")
  public String getHttps() {
    return https;
  }

  public void setHttps(String https) {
    this.https = https;
  }

  public EnvironmentEndpointsDTO ws(String ws) {
    this.ws = ws;
    return this;
  }

   /**
   * WS environment URL
   * @return ws
  **/
  @ApiModelProperty(example = "http://localhost:9099", value = "WS environment URL")
  public String getWs() {
    return ws;
  }

  public void setWs(String ws) {
    this.ws = ws;
  }

  public EnvironmentEndpointsDTO wss(String wss) {
    this.wss = wss;
    return this;
  }

   /**
   * WSS environment URL
   * @return wss
  **/
  @ApiModelProperty(example = "https://localhost:8099", value = "WSS environment URL")
  public String getWss() {
    return wss;
  }

  public void setWss(String wss) {
    this.wss = wss;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    EnvironmentEndpointsDTO environmentEndpoints = (EnvironmentEndpointsDTO) o;
    return Objects.equals(this.http, environmentEndpoints.http) &&
        Objects.equals(this.https, environmentEndpoints.https) &&
        Objects.equals(this.ws, environmentEndpoints.ws) &&
        Objects.equals(this.wss, environmentEndpoints.wss);
  }

  @Override
  public int hashCode() {
    return Objects.hash(http, https, ws, wss);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class EnvironmentEndpointsDTO {\n");
    
    sb.append("    http: ").append(toIndentedString(http)).append("\n");
    sb.append("    https: ").append(toIndentedString(https)).append("\n");
    sb.append("    ws: ").append(toIndentedString(ws)).append("\n");
    sb.append("    wss: ").append(toIndentedString(wss)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(java.lang.Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }

}
