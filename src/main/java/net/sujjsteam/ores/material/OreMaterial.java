package net.sujjsteam.ores.material;

public enum OreMaterial {
    ALUMINUM("aluminum", 0xD6D6DA, true),
    LEAD("lead", 0x606284, false),
    NICKEL("nickel", 0xD6CEA0, true),
    SILVER("silver", 0xECF2FF, true),
    TIN("tin", 0x96A4B4, false),
    ZINC("zinc", 0xA8C0B2, true),
    OSMIUM("osmium", 0x84A8CC, false),
    PLATINUM("platinum", 0x96E4F0, true),
    URANIUM("uranium", 0x70CC3E, false),
    IRIDIUM("iridium", 0xC4A0E8, true);

    public final String id;
    public final int color;
    public final boolean mekanismProcessing;

    OreMaterial(String id, int color, boolean mekanismProcessing) {
        this.id = id;
        this.color = color;
        this.mekanismProcessing = mekanismProcessing;
    }
}
