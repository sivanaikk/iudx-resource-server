package iudx.resource.server.apiserver.response;

import io.vertx.core.json.JsonObject;

public class RestResponse {
  private int type;
  private String title;
  private String detail;

  private RestResponse(ResponseType error, String message) {
    super();
    this.type = error.getCode();
    this.title = error.getMessage();
    this.detail = message;
  }

  private JsonObject toJson() {
    JsonObject json = new JsonObject();
    json.put("type", this.type);
    json.put("title", this.title);
    json.put("detail", this.detail);
    return json;
  }

  public String toJsonString() {
    return toJson().toString();
  }

  public static class Builder {
    private ResponseType error;
    private String message;

    public Builder() {}

    public Builder withError(ResponseType error) {
      this.error = error;
      return this;
    }

    public Builder withMessage(String message) {
      this.message = message;
      return this;
    }

    public RestResponse build() {
      return new RestResponse(this.error, this.message);
    }
  }

}
