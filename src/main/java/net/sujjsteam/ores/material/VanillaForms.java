package net.sujjsteam.ores.material;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public final class VanillaForms {

    public static final Map<String, List<String>> FORMS;

    static {
        List<String> metal = List.of("dust", "plate", "gear", "rod");
        List<String> metalWithNugget = List.of("nugget", "dust", "plate", "gear", "rod");
        List<String> dustOnly = List.of("dust");
        Map<String, List<String>> forms = new LinkedHashMap<>();
        forms.put("iron", metal);
        forms.put("gold", metal);
        forms.put("copper", metalWithNugget);
        forms.put("netherite", metalWithNugget);
        forms.put("diamond", metal);
        forms.put("emerald", metal);
        forms.put("lapis", metal);
        forms.put("quartz", metal);
        forms.put("amethyst", metal);
        forms.put("obsidian", metal);
        forms.put("coal", dustOnly);
        forms.put("charcoal", dustOnly);
        forms.put("ender_pearl", dustOnly);
        FORMS = Collections.unmodifiableMap(forms);
    }

    private VanillaForms() {
    }
}
