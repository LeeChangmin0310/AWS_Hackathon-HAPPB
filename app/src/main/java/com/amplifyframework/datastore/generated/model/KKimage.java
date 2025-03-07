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

/** This is an auto generated class representing the KKimage type in your schema. */
@SuppressWarnings("all")
@ModelConfig(pluralName = "KKimages", type = Model.Type.USER, version = 1, authRules = {
  @AuthRule(allow = AuthStrategy.PUBLIC, operations = { ModelOperation.CREATE, ModelOperation.UPDATE, ModelOperation.DELETE, ModelOperation.READ })
})
public final class KKimage implements Model {
  public static final QueryField ID = field("KKimage", "id");
  public static final QueryField USER = field("KKimage", "user");
  public static final QueryField IMAGE_URL = field("KKimage", "imageURL");
  public static final QueryField TEXT = field("KKimage", "text");
  private final @ModelField(targetType="ID", isRequired = true) String id;
  private final @ModelField(targetType="String") String user;
  private final @ModelField(targetType="String") String imageURL;
  private final @ModelField(targetType="String") String text;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime createdAt;
  private @ModelField(targetType="AWSDateTime", isReadOnly = true) Temporal.DateTime updatedAt;
  public String resolveIdentifier() {
    return id;
  }
  
  public String getId() {
      return id;
  }
  
  public String getUser() {
      return user;
  }
  
  public String getImageUrl() {
      return imageURL;
  }
  
  public String getText() {
      return text;
  }
  
  public Temporal.DateTime getCreatedAt() {
      return createdAt;
  }
  
  public Temporal.DateTime getUpdatedAt() {
      return updatedAt;
  }
  
  private KKimage(String id, String user, String imageURL, String text) {
    this.id = id;
    this.user = user;
    this.imageURL = imageURL;
    this.text = text;
  }
  
  @Override
   public boolean equals(Object obj) {
      if (this == obj) {
        return true;
      } else if(obj == null || getClass() != obj.getClass()) {
        return false;
      } else {
      KKimage kKimage = (KKimage) obj;
      return ObjectsCompat.equals(getId(), kKimage.getId()) &&
              ObjectsCompat.equals(getUser(), kKimage.getUser()) &&
              ObjectsCompat.equals(getImageUrl(), kKimage.getImageUrl()) &&
              ObjectsCompat.equals(getText(), kKimage.getText()) &&
              ObjectsCompat.equals(getCreatedAt(), kKimage.getCreatedAt()) &&
              ObjectsCompat.equals(getUpdatedAt(), kKimage.getUpdatedAt());
      }
  }
  
  @Override
   public int hashCode() {
    return new StringBuilder()
      .append(getId())
      .append(getUser())
      .append(getImageUrl())
      .append(getText())
      .append(getCreatedAt())
      .append(getUpdatedAt())
      .toString()
      .hashCode();
  }
  
  @Override
   public String toString() {
    return new StringBuilder()
      .append("KKimage {")
      .append("id=" + String.valueOf(getId()) + ", ")
      .append("user=" + String.valueOf(getUser()) + ", ")
      .append("imageURL=" + String.valueOf(getImageUrl()) + ", ")
      .append("text=" + String.valueOf(getText()) + ", ")
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
  public static KKimage justId(String id) {
    return new KKimage(
      id,
      null,
      null,
      null
    );
  }
  
  public CopyOfBuilder copyOfBuilder() {
    return new CopyOfBuilder(id,
      user,
      imageURL,
      text);
  }
  public interface BuildStep {
    KKimage build();
    BuildStep id(String id);
    BuildStep user(String user);
    BuildStep imageUrl(String imageUrl);
    BuildStep text(String text);
  }
  

  public static class Builder implements BuildStep {
    private String id;
    private String user;
    private String imageURL;
    private String text;
    @Override
     public KKimage build() {
        String id = this.id != null ? this.id : UUID.randomUUID().toString();
        
        return new KKimage(
          id,
          user,
          imageURL,
          text);
    }
    
    @Override
     public BuildStep user(String user) {
        this.user = user;
        return this;
    }
    
    @Override
     public BuildStep imageUrl(String imageUrl) {
        this.imageURL = imageUrl;
        return this;
    }
    
    @Override
     public BuildStep text(String text) {
        this.text = text;
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
    private CopyOfBuilder(String id, String user, String imageUrl, String text) {
      super.id(id);
      super.user(user)
        .imageUrl(imageUrl)
        .text(text);
    }
    
    @Override
     public CopyOfBuilder user(String user) {
      return (CopyOfBuilder) super.user(user);
    }
    
    @Override
     public CopyOfBuilder imageUrl(String imageUrl) {
      return (CopyOfBuilder) super.imageUrl(imageUrl);
    }
    
    @Override
     public CopyOfBuilder text(String text) {
      return (CopyOfBuilder) super.text(text);
    }
  }
  
}
