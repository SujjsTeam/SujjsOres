package net.sujjsteam.ores.material;

public enum AlloyMaterial {
    BRASS("brass"),
    BRONZE("bronze"),
    CONSTANTAN("constantan"),
    ELECTRUM("electrum"),
    ENDERIUM("enderium"),
    INVAR("invar"),
    LUMIUM("lumium"),
    SIGNALUM("signalum"),
    STEEL("steel");

    public final String id;

    AlloyMaterial(String id) {
        this.id = id;
    }
}
