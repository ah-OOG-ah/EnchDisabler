package klaxon.enchdisabler.events;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AnvilUpdateHandler {
    @SubscribeEvent
    public static void AnvilUpdateHandler(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        JsonParser jsonParser = new JsonParser();

        for (INBT nbt : left.getEnchantmentTagList()) {
            JsonElement enchantment = jsonParser.parse(nbt.toString());
            if (enchantment.getAsJsonObject().get("id").toString().equals("minecraft:feather_falling")) {
                event.setCanceled(true);
            }
        }
        for (INBT nbt : right.getEnchantmentTagList()) {
            JsonElement enchantment = jsonParser.parse(nbt.toString());
            if (enchantment.getAsJsonObject().get("id").toString().equals("minecraft:feather_falling")) {
                event.setCanceled(true);
            }
        }
    }
}
