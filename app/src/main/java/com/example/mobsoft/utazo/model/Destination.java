package com.example.mobsoft.utazo.model;

import java.util.Objects;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import com.google.gson.annotations.SerializedName;
import com.orm.SugarRecord;

@ApiModel(description = "")
public class Destination extends SugarRecord{

    @SerializedName("name")
    private String name = null;

    @SerializedName("description")
    private String description = null;

    @SerializedName("image")
    private String image = null;

    @SerializedName("country")
    private String country = null;


    public enum StatusEnum {
        @SerializedName("Visited")
        VISITED("Visited"),

        @SerializedName("Not visited")
        NOT_VISITED("Not visited");

        private String value;

        StatusEnum(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return value;
        }
    }

    @SerializedName("status")
    private StatusEnum status = null;



    /**
     **/
    @ApiModelProperty(value = "")
    public Long getId() {
        return super.getId();
    }
    public void setId(Long id) {
        super.setId(id);
    }


    /**
     **/
    @ApiModelProperty(required = true, value = "")
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }


    /**
     **/
    @ApiModelProperty(required = true, value = "")
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }


    /**
     **/
    @ApiModelProperty(value = "")
    public String getCountry() {
        return country;
    }
    public void setCountry(String country) {
        this.country = country;
    }


    /**
     * Destination status
     **/
    @ApiModelProperty(value = "Destination status")
    public StatusEnum getStatus() {
        return status;
    }
    public void setStatus(StatusEnum status) {
        this.status = status;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Destination destination = (Destination) o;
        return Objects.equals(super.getId(), destination.getId()) &&
                Objects.equals(name, destination.name) &&
                Objects.equals(description, destination.description) &&
                Objects.equals(image, destination.image) &&
                Objects.equals(country, destination.country) &&
                Objects.equals(status, destination.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.getId(), name, description, image, country, status);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("class Destination {\n");

        sb.append("    id: ").append(toIndentedString(super.getId())).append("\n");
        sb.append("    name: ").append(toIndentedString(name)).append("\n");
        sb.append("    description: ").append(toIndentedString(description)).append("\n");
        sb.append("    image: ").append(toIndentedString(image)).append("\n");
        sb.append("    country: ").append(toIndentedString(country)).append("\n");
        sb.append("    status: ").append(toIndentedString(status)).append("\n");
        sb.append("}");
        return sb.toString();
    }

    /**
     * Convert the given object to string with each line indented by 4 spaces
     * (except the first line).
     */
    private String toIndentedString(Object o) {
        if (o == null) {
            return "null";
        }
        return o.toString().replace("\n", "\n    ");
    }
}

