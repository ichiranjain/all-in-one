package shipping.spring.data.neo4j.model;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.wordnik.swagger.annotations.ApiModel;
import com.wordnik.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Path Request Object, containing flow information(five-tuple).")
@JsonInclude(Include.NON_NULL)
public class OrderRequest {
    private Long orderNumber;
    private String orderType;
    private String sourceAddress;
    private String destinationAddress;
    private String personName;
    private String personBorn;

    @JsonIgnore
    private static final Logger LOGGER = LoggerFactory.getLogger(OrderRequest.class);


    public OrderRequest() {
    }

    public OrderRequest(OrderRequest orderRequest) {
        this.orderNumber = orderRequest.orderNumber;
        this.orderType = orderRequest.orderType;
        this.sourceAddress = orderRequest.sourceAddress;
        this.destinationAddress = orderRequest.destinationAddress;
        this.personName = orderRequest.personName;
        this.personBorn = orderRequest.personBorn;
    }

    public OrderRequest(Long orderNumber, String orderType, String sourceAddress, String destinationAddress, String personName, String personBorn) {
        try {
            setOrderNumber(orderNumber);
            setOrderType(orderType);
            setSourceAddress(sourceAddress);
            setDestinationAddress(destinationAddress);
            setPersonName(personName);
            setPersonBorn(personBorn);
        }catch (Exception ex){
            LOGGER.error("Exception thrown:{}", ex.getMessage());
        }

    }

    @ApiModelProperty(value = "Set Order Number", required = true)
    public void setOrderNumber(Long orderNumber) throws  Exception {
        if(orderNumber == null){
            throw new Exception("Empty Order Number");
        }else{
            this.orderNumber = orderNumber;
        }
    }

    public Long getOrderNumber() {
        return this.orderNumber;
    }

    @ApiModelProperty(value = "Set Order Type", required = true)
    public void setOrderType(String orderType) throws  Exception {
        if(orderType == null){
            throw new Exception("Empty Order Type");
        }else{
            this.orderType = orderType;
        }
    }

    public String getOrderType() {
        return this.orderType;
    }

    @ApiModelProperty(value = "Set Order Source Address", required = true)
    public void setSourceAddress(String sourceAddress) throws  Exception {
        if(sourceAddress == null){
            throw new Exception("Empty Source Address");
        }else{
            this.sourceAddress = sourceAddress;
        }
    }

    public String getSourceAddress() {
        return this.sourceAddress;
    }

    @ApiModelProperty(value = "Set Order Destination Address", required = true)
    public void setDestinationAddress(String destinationAddress) throws  Exception {
        if(destinationAddress == null){
            throw new Exception("Empty Destination Address");
        }else{
            this.destinationAddress = destinationAddress;
        }
    }

    public String getDestinationAddress() {
        return this.destinationAddress;
    }

    @ApiModelProperty(value = "Set Order Person Name", required = true)
    public void setPersonName(String personName) throws  Exception {
        if(personName == null){
            throw new Exception("Empty Person Name");
        }else{
            this.personName = personName;
        }
    }

    public String getPersonName() {
        return this.personName;
    }

    @ApiModelProperty(value = "Set Order Person Born", required = true)
    public void setPersonBorn(String personBorn) throws  Exception {
        if(personBorn == null){
            throw new Exception("Empty Person Born");
        }else{
            this.personBorn = personBorn;
        }
    }

    public String getPersonBorn() {
        return this.personBorn;
    }


    @Override
    public String toString() {
        return "PathRequest [orderNumber=" + orderNumber + ", orderType=" + orderType + ", sourceAddress=" + sourceAddress
                + ", destinationAddress=" + destinationAddress + ", personName=" + personName + ", personBorn=" + personBorn + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((orderNumber == null) ? 0 : orderNumber.hashCode());
        result = prime * result + ((orderType == null) ? 0 : orderType.hashCode());
        result = prime * result + ((sourceAddress == null) ? 0 : sourceAddress.hashCode());
        result = prime * result + ((destinationAddress == null) ? 0 : destinationAddress.hashCode());
        result = prime * result + ((personName == null) ? 0 : personName.hashCode());
        result = prime * result + ((personBorn == null) ? 0 : personBorn.hashCode());
        return result;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final OrderRequest other = (OrderRequest) obj;
        if (orderNumber == null) {
            if (other.orderNumber != null) {
                return false;
            }
        } else if (!orderNumber.equals(other.orderNumber)) {
            return false;
        }
        if (orderType == null) {
            if (other.orderType != null) {
                return false;
            }
        } else if (!orderType.equals(other.orderType)) {
            return false;
        }
        if (sourceAddress == null) {
            if (other.sourceAddress != null) {
                return false;
            }
        } else if (!sourceAddress.equals(other.sourceAddress)) {
            return false;
        }
        if (destinationAddress == null) {
            if (other.destinationAddress != null) {
                return false;
            }
        } else if (!destinationAddress.equals(other.destinationAddress)) {
            return false;
        }
        if (personName == null) {
            if (other.personName != null) {
                return false;
            }
        } else if (!personName.equals(other.personName)) {
            return false;
        }
        if (personBorn == null) {
            if (other.personBorn != null) {
                return false;
            }
        } else if (!personBorn.equals(other.personBorn)) {
            return false;
        }

        return true;
    }


    }

