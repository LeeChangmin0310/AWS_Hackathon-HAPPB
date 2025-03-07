package com.amplifyframework.datastore.generated.model;

import com.amplifyframework.core.model.temporal.Temporal;

import java.util.List;
import java.util.UUID;
import java.util.Objects;

import androidx.core.util.ObjectsCompat;

import com.amplifyframework.core.model.AuthStrategy;
import com.amplifyframework.core.model.Model;
import com.amplifyframework.core.model.ModelOperation;
import com.amplifyframework.core.model.annotations.AuthRule;
import com.amplifyframework.core.model.annotations.Index;
import com.amplifyframework.core.model.annotations.ModelConfig;
import com.amplifyframework.core.model.annotations.ModelField;
import com.amplifyframework.core.model.query.predicate.QueryField;

import static com.amplifyframework.core.model.query.predicate.QueryField.field;

/** This is an auto generated class representing the Information type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Information", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Information implements Model {
  public static final QueryField ID = field("Information", "id");
  public static final QueryField NAME = field("Information", "name");
  public static final QueryField AGE = field("Information", "age");
  public static final QueryField HEIGHT = field("Information", "height");
  public static final QueryField WEIGHT = field("Information", "weight");
  public static final QueryField NUMBER = field("Information", "number");
  public static final QueryField USER = field("Information", "user");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String name;
  private final @ModelField(targetType="Int") Integer age;
  private final @ModelField(targetType="Int") Integer height;
  private final @ModelField(targetType="Int") Integer weight;
  private final @ModelField(targetType="Int") Integer number;
  private final @ModelField(targetType="String") String user;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getName() {
      return name;
  }
  
  public Integer getAge() {
      return age;
  }
  
  public Integer getHeight() {
      return height;
  }
  
  public Integer getWeight() {
      return weight;
  }
  
  public Integer getNumber() {
      return number;
  }
  
  public String getUser() {
      return user;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Information(String id, String name, Integer age, Integer height, Integer weight, Integer number, String user) {
    this.id = id;
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.number = number;
    this.user = user;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Information information = (Information) obj;
      return ObjectsCompat.equals(getId(), information.getId()) &&
              ObjectsCompat.equals(getName(), information.getName()) &&
              ObjectsCompat.equals(getAge(), information.getAge()) &&
              ObjectsCompat.equals(getHeight(), information.getHeight()) &&
              ObjectsCompat.equals(getWeight(), information.getWeight()) &&
              ObjectsCompat.equals(getNumber(), information.getNumber()) &&
              ObjectsCompat.equals(getUser(), information.getUser()) &&
              ObjectsCompat.equals(getCreatedAt(), information.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), information.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getName())
      .append(getAge())
      .append(getHeight())
      .append(getWeight())
      .append(getNumber())
      .append(getUser())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Information {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("age=" + String.valueOf(getAge()) + ", ")
      .append("height=" + String.valueOf(getHeight()) + ", ")
      .append("weight=" + String.valueOf(getWeight()) + ", ")
      .append("number=" + String.valueOf(getNumber()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
      .append("createdAt=" + String.valueOf(getCreatedAt()) + ", ")
      .append("updatedAt=" + String.valueOf(getUpdatedAt()))
      .append("}")
      .toString();
  }
  
  public static BuildStep builder() {
      return new Builder();
  }
  
  /**
   * WARNING: This method should not be used to build an instance of this object for a CREATE mutation.
   * This is a convenience method to return an instance of the object with only its ID populated
   * to be used in the context of a parameter in a delete mutation or referencing a foreign key
   * in a relationship.
   * @param id the id of the existing item this instance will represent
   * @return an instance of this model with only ID populated
   */
  public static Information justId(String id) {
    return new Information(
      id,
      null,
      null,
      null,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      name,
      age,
      height,
      weight,
      number,
      user);
  }
  public interface BuildStep {
    Information build();
    BuildStep id(String id);
    BuildStep name(String name);
    BuildStep age(Integer age);
    BuildStep height(Integer height);
    BuildStep weight(Integer weight);
    BuildStep number(Integer number);
    BuildStep user(String user);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Integer number;
    private String user;
    @Override
     public Information build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Information(
          id,
          name,
          age,
          height,
          weight,
          number,
          user);
    }
    
    @Override
     public BuildStep name(String name) {
        this.name = name;
        return this;
    }
    
    @Override
     public BuildStep age(Integer age) {
        this.age = age;
        return this;
    }
    
    @Override
     public BuildStep height(Integer height) {
        this.height = height;
        return this;
    }
    
    @Override
     public BuildStep weight(Integer weight) {
        this.weight = weight;
        return this;
    }
    
    @Override
     public BuildStep number(Integer number) {
        this.number = number;
        return this;
    }
    
    @Override
     public BuildStep user(String user) {
        this.user = user;
        return this;
    }
    
    /**
     * @param id id
     * @return Current Builder instance, for fluent method chaining
     */
    public BuildStep id(String id) {
        this.id = id;
        return this;
    }
  }
  

  public final class CopyOfBuilder extends Builder {
    private CopyOfBuilder(String id, String name, Integer age, Integer height, Integer weight, Integer number, String user) {
      super.id(id);
      super.name(name)
        .age(age)
        .height(height)
        .weight(weight)
        .number(number)
        .user(user);
    }
    
    @Override
     public CopyOfBuilder name(String name) {
      return (CopyOfBuilder) super.name(name);
    }
    
    @Override
     public CopyOfBuilder age(Integer age) {
      return (CopyOfBuilder) super.age(age);
    }
    
    @Override
     public CopyOfBuilder height(Integer height) {
      return (CopyOfBuilder) super.height(height);
    }
    
    @Override
     public CopyOfBuilder weight(Integer weight) {
      return (CopyOfBuilder) super.weight(weight);
    }
    
    @Override
     public CopyOfBuilder number(Integer number) {
      return (CopyOfBuilder) super.number(number);
    }
    
    @Override
     public CopyOfBuilder user(String user) {
      return (CopyOfBuilder) super.user(user);
    }
  }
  
}
