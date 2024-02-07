package org.openapitools.client.model;

public class ActivityResponse{
    private String activity;
    private String price;
    private String type;
    private String participants;
    private String accessibility;

    public ActivityResponse() {
    }

    public ActivityResponse(String activity, String price, String type, String participants, String accessibility) {
        this.activity = activity;
        this.price = price;
        this.type = type;
        this.participants = participants;
        this.accessibility = accessibility;
    }

    public String getActivity() {
        return activity;
    }

    public void setActivity(String activity) {
        this.activity = activity;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getParticipants() {
        return participants;
    }

    public void setParticipants(String participants) {
        this.participants = participants;
    }

    public String getAccessibility() {
        return accessibility;
    }

    public void setAccessibility(String accessibility) {
        this.accessibility = accessibility;
    }

    @Override
    public String toString() {
        return String.format(
                "[ACTIVITY]: %s%n[PRICE]: %s%n[TYPE]: %s%n[PARTICIPANTS]: %s%n[ACCESSIBILITY]: %s"
                ,activity, price, type, participants, accessibility
        );
    }
}


