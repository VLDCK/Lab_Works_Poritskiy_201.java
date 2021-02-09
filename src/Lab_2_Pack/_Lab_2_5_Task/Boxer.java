package Lab_2_Pack._Lab_2_5_Task;

public class Boxer implements SportInterface {

    float time;

    @Override
    public void setTimeOfEvent(float time) {
    this.time = time;
    }

    @Override
    public String nameOfEvent() {
        return "Box";
    }

    @Override
    public boolean isTeamSport() {
        return false;
    }
}
