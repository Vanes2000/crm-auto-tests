package crm.preset.role;

public enum Role {

    DBA("[1,2,4,6,7]",
            "[1,2,3,4,5,6,7,8,9,10,11,12,13]",
            1,
            "",
            "#000000",
            false),

    MANAGER_RETAIL("[1]",
            "[1,2,3,4,5]",
            4,
            "",
            "#000000",
            false);

    private final String directionJson;

    private final String objectType;

    private final int permissionId;

    private final String officeId;

    private final String color;

    private final boolean isChief;

    public String getDirectionJson() {
        return directionJson;
    }

    public String getObjectType() {
        return objectType;
    }

    public int getPermissionId() {
        return permissionId;
    }

    public String getOfficeId() {
        return officeId;
    }

    public String getColor() {
        return color;
    }

    public boolean isChief() {
        return isChief;
    }

    Role(String directionJson, String objectType, int permissionId, String officeId, String color, boolean isChief) {
        this.directionJson = directionJson;
        this.objectType = objectType;
        this.permissionId = permissionId;
        this.officeId = officeId;
        this.color = color;
        this.isChief = isChief;
    }

}