package eu.floppaware.feature.impl.misc;

import eu.floppaware.Main;
import eu.floppaware.event.EventTarget;
import eu.floppaware.event.events.impl.packet.EventSendPacket;
import eu.floppaware.feature.Category;
import eu.floppaware.feature.Feature;
import eu.floppaware.settings.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.entity.Entity;
import net.minecraft.network.play.client.CPacketUseEntity;

import java.security.SecureRandom;
import java.util.Random;

public class BullingBot<TimerUtils>
        extends Feature {
    TimerUtils timer = new TimerUtils();
    String lastMessage = "";
    Random random;
    Setting delay = new Setting("Delay", this, 3000.0, 1.0, 20000.0, false);
    private static String alphabet = "ABCDEFG!()1234%$#@!^%&*()_567890~]''/.,[HIJKLMNOPQRSTUVWXYZ";
    private static final SecureRandom secureRandom = new SecureRandom();

    public BullingBot() {
        super("BullingBot", Category.Misc);
        Main.instance.setmgr.rSetting(this.delay);
    }

    public static String randomString(int strLength) {
        StringBuilder stringBuilder = new StringBuilder(strLength);
        for (int i = 0; i < strLength; ++i) {
            stringBuilder.append(alphabet.charAt(secureRandom.nextInt(alphabet.length())));
        }
        return stringBuilder.toString();
    }

    @EventTarget
    public void onPacket(EventSendPacket event) {
        Entity targetEntity;
        CPacketUseEntity cPacketUseEntity;
        if (event.getPacket() instanceof CPacketUseEntity && (cPacketUseEntity = (CPacketUseEntity)event.getPacket()).getAction().equals(CPacketUseEntity.Action.ATTACK) && (targetEntity = cPacketUseEntity.getEntityFromWorld(BullingBot.mc.world)) instanceof EntityPlayer) {
            String[] messages = new String[]{"я ебал твою мать"};
            String finalText = messages[new Random().nextInt(messages.length)];
            if (BullingBot.mc.currentScreen == null) {
                if (Minecraft.player.isServerWorld() && BullingBot.mc.world != null && (!this.timer.hasReached(this.delay.getValFloat()) || this.lastMessage.equals(finalText)) || this.lastMessage == null)) {
                    Minecraft.player.sendChatMessage("![FloppaWare] " + targetEntity.getName() + " " + finalText + " [" + BullingBot.randomString(10) + "]");
                    this.lastMessage = finalText;
                    this.timer.reset();
                }
            }
        }
    }

    static {
        alphabet = alphabet + alphabet.toLowerCase();
    }
}
