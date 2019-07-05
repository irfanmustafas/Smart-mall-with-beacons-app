package pgmall.beacon_mall.modules;


public class DataModule {
    String name, phone, uri, email, website, description, category, beacon_id, map_id,
            uri1, uri2, uri3, uri4, uri5;

    public DataModule() {
    }

    public DataModule(String name, String phone, String uri, String email, String website, String description,
                      String category, String beacon_id, String map_id,
                      String uri1, String uri2, String uri3, String uri4, String uri5
    ) {
        this.name = name;
        this.uri = uri;
        this.phone = phone;
        this.email = email;
        this.website = website;
        this.description = description;
        this.category = category;
        this.map_id = map_id;
        this.beacon_id = beacon_id;
        this.uri1 = uri1;
        this.uri2 = uri2;
        this.uri3 = uri3;
        this.uri4 = uri4;
        this.uri5 = uri5;
    }

    public String getUri1() {
        return uri1;
    }

    public void setUri1(String uri1) {
        this.uri1 = uri1;
    }

    public String getUri2() {
        return uri2;
    }

    public void setUri2(String uri2) {
        this.uri2 = uri2;
    }

    public String getUri3() {
        return uri3;
    }

    public void setUri3(String uri3) {
        this.uri3 = uri3;
    }

    public String getUri4() {
        return uri4;
    }

    public void setUri4(String uri4) {
        this.uri4 = uri4;
    }

    public String getUri5() {
        return uri5;
    }

    public void setUri5(String uri5) {
        this.uri5 = uri5;
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getUri() {
        return uri;
    }

    public String getEmail() {
        return email;
    }

    public String getWebsite() {
        return website;
    }

    public String getDescription() {
        return description;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getBeacon_id() {
        return beacon_id;
    }

    public void setBeacon_id(String beacon_id) {
        this.beacon_id = beacon_id;
    }

    public String getMap_id() {
        return map_id;
    }

    public void setMap_id(String map_id) {
        this.map_id = map_id;
    }
}
