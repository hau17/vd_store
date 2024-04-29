package phonestore.DTO;

public class OriginDTO {
    private int origin_id;
    private String origin_name;

    public OriginDTO(int origin_id, String origin_name) {
        this.origin_id = origin_id;
        this.origin_name = origin_name;
    }

    public OriginDTO() {
    }

    public int getOrigin_id() {
        return origin_id;
    }

    public void setOrigin_id(int origin_id) {
        this.origin_id = origin_id;
    }

    public String getOrigin_name() {
        return origin_name;
    }

    public void setOrigin_name(String origin_name) {
        this.origin_name = origin_name;
    }

}