package enumerations;

/**
 * Represents a unit of measurement.
 *
 * @author renantdesouza.
 * @since 03/08/2016.
 */
public enum Measure {

    ;

    private byte code;
    private String desc;

    Measure(byte code,String desc) {
        this.code = code;
        this.desc=  desc;
    }

    public byte getCode() {
        return code;
    }

    public String getDesc() {
        return desc;
    }

    public static Measure getByCode(int code) {
        return getByCode((byte) code);
    }

    public static Measure getByCode(byte code) {
        for (Measure m : values()) {
            if (m.code == code) return m;
        }
        return null;
    }

    public static Measure getDesc(String desc) {
        for (Measure m : values()) {
            if (m.desc.equalsIgnoreCase(desc)) return m;
        }
        return null;
    }

}
