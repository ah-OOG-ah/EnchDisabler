package klaxon.enchdisabler.events;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.INBT;
import net.minecraftforge.event.AnvilUpdateEvent;
import net.minecraftforge.eventbus.api.Event;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod;

@Mod.EventBusSubscriber
public class AnvilUpdateHandler {
    @SubscribeEvent
    public static void AnvilUpdateHandler(AnvilUpdateEvent event) {
        ItemStack left = event.getLeft();
        ItemStack right = event.getRight();
        JsonParser jsonParser = new JsonParser();
        String banned = "\"minecraft:protection\"";



        for (INBT nbt : left.getEnchantmentTagList()) {
            JsonElement enchantment = jsonParser.parse(nbt.toString());

            if (enchantment.getAsJsonObject().get("id").toString().equals(banned)) {
                //event.setCanceled(true);
                //event.setResult(Event.Result.DENY);
                event.setOutput(ItemStack.EMPTY);
                event.setCost(0);
                return;
            }
        }
        for (INBT nbt : right.getEnchantmentTagList()) {
            JsonElement enchantment = jsonParser.parse(nbt.toString());

            if (enchantment.getAsJsonObject().get("id").toString().equals(banned)) {
                //event.setCanceled(true);
                //event.setResult(Event.Result.DENY);
                event.setOutput(ItemStack.EMPTY);
                event.setCost(0);
                return;
            }
        }
    }
}
