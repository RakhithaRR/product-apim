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


package org.wso2.am.integration.clients.store.api.v1.dto;

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
import org.wso2.am.integration.clients.store.api.v1.dto.APIMonetizationAttributesDTO;

/**
 * APITiersDTO
 */

public class APITiersDTO {
  @SerializedName("tierName")
  private String tierName = null;

  @SerializedName("tierPlan")
  private String tierPlan = null;

  @SerializedName("monetizationAttributes")
  private APIMonetizationAttributesDTO monetizationAttributes = null;

  public APITiersDTO tierName(String tierName) {
    this.tierName = tierName;
    return this;
  }

   /**
   * Get tierName
   * @return tierName
  **/
  @ApiModelProperty(example = "Gold", value = "")
  public String getTierName() {
    return tierName;
  }

  public void setTierName(String tierName) {
    this.tierName = tierName;
  }

  public APITiersDTO tierPlan(String tierPlan) {
    this.tierPlan = tierPlan;
    return this;
  }

   /**
   * Get tierPlan
   * @return tierPlan
  **/
  @ApiModelProperty(example = "COMMERCIAL", value = "")
  public String getTierPlan() {
    return tierPlan;
  }

  public void setTierPlan(String tierPlan) {
    this.tierPlan = tierPlan;
  }

  public APITiersDTO monetizationAttributes(APIMonetizationAttributesDTO monetizationAttributes) {
    this.monetizationAttributes = monetizationAttributes;
    return this;
  }

   /**
   * Get monetizationAttributes
   * @return monetizationAttributes
  **/
  @ApiModelProperty(value = "")
  public APIMonetizationAttributesDTO getMonetizationAttributes() {
    return monetizationAttributes;
  }

  public void setMonetizationAttributes(APIMonetizationAttributesDTO monetizationAttributes) {
    this.monetizationAttributes = monetizationAttributes;
  }


  @Override
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    APITiersDTO apITiers = (APITiersDTO) o;
    return Objects.equals(this.tierName, apITiers.tierName) &&
        Objects.equals(this.tierPlan, apITiers.tierPlan) &&
        Objects.equals(this.monetizationAttributes, apITiers.monetizationAttributes);
  }

  @Override
  public int hashCode() {
    return Objects.hash(tierName, tierPlan, monetizationAttributes);
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class APITiersDTO {\n");
    
    sb.append("    tierName: ").append(toIndentedString(tierName)).append("\n");
    sb.append("    tierPlan: ").append(toIndentedString(tierPlan)).append("\n");
    sb.append("    monetizationAttributes: ").append(toIndentedString(monetizationAttributes)).append("\n");
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

