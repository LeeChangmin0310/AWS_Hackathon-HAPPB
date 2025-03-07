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

/** This is an auto generated class representing the Login type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "Logins", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class Login implements Model {
  public static final QueryField ID = field("Login", "id");
  public static final QueryField ID2 = field("Login", "id2");
  public static final QueryField PASSWORD = field("Login", "password");
  public static final QueryField NAME = field("Login", "name");
  public static final QueryField AGE = field("Login", "age");
  public static final QueryField HEIGHT = field("Login", "height");
  public static final QueryField WEIGHT = field("Login", "weight");
  public static final QueryField NUMBER = field("Login", "number");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String id2;
  private final @ModelField(targetType="String") String password;
  private final @ModelField(targetType="String") String name;
  private final @ModelField(targetType="Int") Integer age;
  private final @ModelField(targetType="Int") Integer height;
  private final @ModelField(targetType="Int") Integer weight;
  private final @ModelField(targetType="Int") Integer number;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getId2() {
      return id2;
  }
  
  public String getPassword() {
      return password;
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
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private Login(String id, String id2, String password, String name, Integer age, Integer height, Integer weight, Integer number) {
    this.id = id;
    this.id2 = id2;
    this.password = password;
    this.name = name;
    this.age = age;
    this.height = height;
    this.weight = weight;
    this.number = number;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      Login login = (Login) obj;
      return ObjectsCompat.equals(getId(), login.getId()) &&
              ObjectsCompat.equals(getId2(), login.getId2()) &&
              ObjectsCompat.equals(getPassword(), login.getPassword()) &&
              ObjectsCompat.equals(getName(), login.getName()) &&
              ObjectsCompat.equals(getAge(), login.getAge()) &&
              ObjectsCompat.equals(getHeight(), login.getHeight()) &&
              ObjectsCompat.equals(getWeight(), login.getWeight()) &&
              ObjectsCompat.equals(getNumber(), login.getNumber()) &&
              ObjectsCompat.equals(getCreatedAt(), login.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), login.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getId2())
      .append(getPassword())
      .append(getName())
      .append(getAge())
      .append(getHeight())
      .append(getWeight())
      .append(getNumber())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("Login {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("id2=" + String.valueOf(getId2()) + ", ")
      .append("password=" + String.valueOf(getPassword()) + ", ")
      .append("name=" + String.valueOf(getName()) + ", ")
      .append("age=" + String.valueOf(getAge()) + ", ")
      .append("height=" + String.valueOf(getHeight()) + ", ")
      .append("weight=" + String.valueOf(getWeight()) + ", ")
      .append("number=" + String.valueOf(getNumber()) + ", ")
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
  public static Login justId(String id) {
    return new Login(
      id,
      null,
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
      id2,
      password,
      name,
      age,
      height,
      weight,
      number);
  }
  public interface BuildStep {
    Login build();
    BuildStep id(String id);
    BuildStep id2(String id2);
    BuildStep password(String password);
    BuildStep name(String name);
    BuildStep age(Integer age);
    BuildStep height(Integer height);
    BuildStep weight(Integer weight);
    BuildStep number(Integer number);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String id2;
    private String password;
    private String name;
    private Integer age;
    private Integer height;
    private Integer weight;
    private Integer number;
    @Override
     public Login build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new Login(
          id,
          id2,
          password,
          name,
          age,
          height,
          weight,
          number);
    }
    
    @Override
     public BuildStep id2(String id2) {
        this.id2 = id2;
        return this;
    }
    
    @Override
     public BuildStep password(String password) {
        this.password = password;
        return this;
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
    private CopyOfBuilder(String id, String id2, String password, String name, Integer age, Integer height, Integer weight, Integer number) {
      super.id(id);
      super.id2(id2)
        .password(password)
        .name(name)
        .age(age)
        .height(height)
        .weight(weight)
        .number(number);
    }
    
    @Override
     public CopyOfBuilder id2(String id2) {
      return (CopyOfBuilder) super.id2(id2);
    }
    
    @Override
     public CopyOfBuilder password(String password) {
      return (CopyOfBuilder) super.password(password);
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
  }
  
}
