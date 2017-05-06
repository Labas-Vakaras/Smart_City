package labasvakaras.smartcity.entities;

/**
 *
 * @author Vasilis Naskos
 */
public enum CityItemType {
    
    UNDEFINED(0), STREET_LIGHT(1), TRAFFIC_LIGHT(2);
    
    private int value;
    
    private CityItemType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
    
}
