package model;
public class Subscription {
    private String plan;
    public Subscription(String plan) { this.plan = plan; }
    public String getPlan() { return plan; }
    public void renew() { System.out.println("Subscription renewed: " + plan); }
}
