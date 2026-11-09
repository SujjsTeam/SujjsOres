package net.sujjsteam.ores.material;

public enum GemMaterial {
    FLUORITE("fluorite", true),
    RUBY("ruby", true),
    SAPPHIRE("sapphire", true),
    SULFUR("sulfur", true),
    NITER("niter", true),
    SALT("salt", false);

    public final String id;
    public final boolean hasGem;

    GemMaterial(String id, boolean hasGem) {
        this.id = id;
        this.hasGem = hasGem;
    }

    public String dustId() {
        return hasGem ? id + "_dust" : id;
    }
}
