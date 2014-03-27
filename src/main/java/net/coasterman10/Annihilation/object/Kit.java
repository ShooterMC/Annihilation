/*******************************************************************************
 * Copyright 2014 stuntguy3000 (Luke Anderson) and coasterman10.
 *  
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 51 Franklin Street, Fifth Floor, Boston,
 * MA 02110-1301, USA.
 ******************************************************************************/
package net.coasterman10.Annihilation.object;

import java.util.ArrayList;
import java.util.List;

import net.coasterman10.Annihilation.listeners.SoulboundListener;

import org.bukkit.ChatColor;
import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.PlayerInventory;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;
import org.bukkit.potion.Potion;
import org.bukkit.potion.PotionEffect;
import org.bukkit.potion.PotionEffectType;
import org.bukkit.potion.PotionType;

public enum Kit {
    CIVILIAN(Material.WORKBENCH) {
        {
            spawnItems.add(new ItemStack(Material.WOOD_SWORD));
            spawnItems.add(new ItemStack(Material.WOOD_PICKAXE));
            spawnItems.add(new ItemStack(Material.WOOD_AXE));
            spawnItems.add(new ItemStack(Material.WORKBENCH));
            lore.add("Tu eres la clave.");
            lore.add("");
            lore.add("Proporciona todo lo");
            lore.add("necesario para tu equipo");
            lore.add("con este kit y preparaos");
            lore.add("para la batalla!")
        }
    },
    WARRIOR(Material.STONE_SWORD) {
        {
            spawnItems.add(new ItemStack(Material.STONE_SWORD));
            spawnItems.add(new ItemStack(Material.WOOD_PICKAXE));
            spawnItems.add(new ItemStack(Material.WOOD_AXE));
            spawnItems.add(new Potion(PotionType.INSTANT_HEAL, 1)
                    .toItemStack(1));
            spawnItems.get(0).addEnchantment(Enchantment.KNOCKBACK, 1);
            lore.add("Eres la espada.");
            lore.add("");
            lore.add("Ingliges +1 de daño con");
            lore.add("cualquier melee.");
            lore.add("");
            lore.add("Aparece con una espada");
            lore.add("con Empuje y pocion de vida");
            lore.add("que te permitira avanzar");
            lore.add("inmediatamente hacia el enemigo");
            lore.add("y atacar!");
        }
    },
    ARCHER(Material.BOW) {
        {
            spawnItems.add(new ItemStack(Material.WOOD_SWORD));
            spawnItems.add(new ItemStack(Material.BOW));
            spawnItems.add(new ItemStack(Material.WOOD_PICKAXE));
            spawnItems.add(new ItemStack(Material.WOOD_AXE));
            spawnItems.add(new ItemStack(Material.WOOD_SPADE));
            spawnItems.add(new Potion(PotionType.INSTANT_HEAL, 1)
                    .toItemStack(1));
            spawnItems.add(new ItemStack(Material.ARROW, 16));
            spawnItems.get(1).addEnchantment(Enchantment.ARROW_KNOCKBACK, 1);
            lore.add("Eres la lluvia.");
            lore.add("");
            lore.add("Infliges +1 de daño con");
            lore.add("un arco y puedes craftear");
            lore.add("lanzas sin plumas.");
            lore.add("");
            lore.add("Pon flint encima de los palos");
            lore.add("a la hora de craftear");
            lore.add("para crear 3 lanzas!");
        }
    },

    MINER(Material.STONE_PICKAXE) {
        {
            spawnItems.add(new ItemStack(Material.WOOD_SWORD));
            spawnItems.add(new ItemStack(Material.STONE_PICKAXE));
            spawnItems.add(new ItemStack(Material.WOOD_AXE));
            spawnItems.add(new ItemStack(Material.FURNACE));
            spawnItems.add(new ItemStack(Material.COAL, 4));
            spawnItems.get(1).addEnchantment(Enchantment.DIG_SPEED, 1);
            lore.add("Eres el oro.");
            lore.add("");
            lore.add("Aparece con un pico de piedra");
            lore.add("con eficiencia y mina una");
            lore.add(")gran cantidad de recursos para");
            lore.add("tu equipo con el bonus de dropeos");
            lore.add("duplicados de minerales!");
        }
    },
    LUMBERJACK(Material.STONE_AXE) {
        {
            spawnItems.add(new ItemStack(Material.WOOD_SWORD));
            spawnItems.add(new ItemStack(Material.WOOD_PICKAXE));
            spawnItems.add(new ItemStack(Material.STONE_AXE));
            spawnItems.get(2).addEnchantment(Enchantment.DIG_SPEED, 1);
            lore.add("Eres la madera.");
            lore.add("");
            lore.add("Aparece con un hacha de");
            lore.add("piedra con eficiencia y aprovecha");
            lore.add("el duplicado de deopeos para abastecer");
            lore.add("a tu equipo con grandes cantidades");
            lore.add("de madera!");
        }
    },
    SCOUT(Material.FISHING_ROD) {
        {
            spawnItems.add(new ItemStack(Material.GOLD_SWORD));
            spawnItems.add(new ItemStack(Material.FISHING_ROD));
            spawnItems.add(new ItemStack(Material.WOOD_PICKAXE));
            spawnItems.add(new ItemStack(Material.WOOD_AXE));
            ItemMeta meta = spawnItems.get(1).getItemMeta();
            meta.setDisplayName("Grapple");
            spawnItems.get(1).setItemMeta(meta);
            lore.add("Eres el veloz.");
            lore.add("");
            lore.add("Usa tu bonus de velocidad");
            lore.add("permanente para moverte con");
            lore.add("rapidez, entrar en bases enemigas");
            lore.add("y saltar obstaculos y objetos");
            lore.add("de defensa enemiga!");
            lore.add("");
            lore.add("Solo puedes llevar armadura");
            lore.add("ligera, algo mas pesado que");
            lore.add("la armadura de cadenas te hara");
            lore.add("ser mas lento.");
        }
    },
    BERSERKER(Material.CHAINMAIL_CHESTPLATE) {
        {
            spawnItems.add(new ItemStack(Material.STONE_SWORD));
            spawnItems.add(new ItemStack(Material.WOOD_PICKAXE));
            spawnItems.add(new ItemStack(Material.WOOD_AXE));
            spawnItems.add(new Potion(PotionType.INSTANT_HEAL, 1)
                    .toItemStack(1));
            lore.add("Eres el tanque.");
            lore.add("");
            lore.add("Aparece con solo 7 corazones");
            lore.add("Por cada enemigo que mates");
            lore.add("obtendras un corazon mas,");
            lore.add("permitiendote ganar hasta");
            lore.add("15 corazones!");
        }
    },
    OPERATIVE(Material.SOUL_SAND) {
        {
            spawnItems.add(new ItemStack(Material.WOOD_SWORD));
            spawnItems.add(new ItemStack(Material.WOOD_PICKAXE));
            spawnItems.add(new ItemStack(Material.WOOD_AXE));
            spawnItems.add(new ItemStack(Material.SOUL_SAND));
            ItemMeta meta = spawnItems.get(3).getItemMeta();
            meta.setDisplayName(ChatColor.AQUA + "Punto de Regreso");
            spawnItems.get(3).setItemMeta(meta);
            lore.add("Eres el <something>");
            lore.add("");
            lore.add("Lleva a cabo tus objetivos");
            lore.add("de ofensa y escapa facilmente!");
            lore.add("");
            lore.add("Apareceras con un bloque de");
            lore.add("soulsand, que cuando lo pones");
            lore.add("establecera el punto de vuelta.");
            lore.add("90 segundos despues seras llevado");
            lore.add("a ese lugar. Asegurate de ponerlo");
            lore.add("en un lugar seguro!");
        }
    };

    static {
        for (Kit kit : values())
            kit.init();
    }

    private ItemStack icon;
    List<String> lore = new ArrayList<String>();
    List<ItemStack> spawnItems = new ArrayList<ItemStack>();
    ItemStack[] spawnArmor = new ItemStack[] {
            new ItemStack(Material.LEATHER_BOOTS),
            new ItemStack(Material.LEATHER_LEGGINGS),
            new ItemStack(Material.LEATHER_CHESTPLATE),
            new ItemStack(Material.LEATHER_HELMET) };

    Kit(Material m) {
        icon = new ItemStack(m);
        ItemMeta meta = icon.getItemMeta();
        meta.setDisplayName(getName());
        icon.setItemMeta(meta);
    }

    private void init() {
        for (int i = 0; i < lore.size(); i++) {
            String s = lore.get(i);
            s = ChatColor.AQUA + s;
            lore.set(i, s);
        }
        ItemMeta meta = icon.getItemMeta();
        meta.setLore(lore);
        icon.setItemMeta(meta);
    }

    public static Kit getKit(String name) {
        for (Kit type : values()) {
            if (type.name().equalsIgnoreCase(name))
                return type;
        }
        return null;
    }

    public void give(Player recipient, GameTeam team) {
        PlayerInventory inv = recipient.getInventory();
        inv.clear();

        for (ItemStack item : spawnItems) {
            ItemStack toGive = item.clone();
            SoulboundListener.soulbind(toGive);
            inv.addItem(toGive);
        }

        recipient.removePotionEffect(PotionEffectType.SPEED);

        ItemStack compass = new ItemStack(Material.COMPASS);
        ItemMeta compassMeta = compass.getItemMeta();
        compassMeta.setDisplayName(team.color() + "Pointing to "
                + team.toString() + " Nexus");
        compass.setItemMeta(compassMeta);
        SoulboundListener.soulbind(compass);

        inv.addItem(compass);
        recipient.setCompassTarget(team.getNexus().getLocation());

        inv.setArmorContents(spawnArmor);
        colorizeArmor(inv, getTeamColor(team));

        for (ItemStack armor : inv.getArmorContents())
            SoulboundListener.soulbind(armor);

        if (this == SCOUT)
            addScoutParticles(recipient);

        if (this == BERSERKER)
            recipient.setMaxHealth(14.0);
        else
            recipient.setMaxHealth(20.0);
    }

    private Color getTeamColor(GameTeam team) {
        switch (team) {
        case RED:
            return Color.RED;
        case YELLOW:
            return Color.YELLOW;
        case GREEN:
            return Color.GREEN;
        case BLUE:
            return Color.BLUE;
        default:
            return Color.WHITE;
        }
    }

    private void colorizeArmor(PlayerInventory inv, Color color) {
        for (ItemStack item : inv.getArmorContents()) {
            if (item.getItemMeta() instanceof LeatherArmorMeta) {
                LeatherArmorMeta meta = (LeatherArmorMeta) item.getItemMeta();
                meta.setColor(color);
                item.setItemMeta(meta);
            }
        }
    }

    public String getName() {
        return name().substring(0, 1) + name().substring(1).toLowerCase();
    }

    public boolean isOwnedBy(Player p) {
        return p.isOp()
                || this == CIVILIAN
                || p.hasPermission("annihilation.class."
                        + getName().toLowerCase());
    }

    public void addScoutParticles(Player p) {
        if (this != SCOUT)
            return;
        p.addPotionEffect(new PotionEffect(PotionEffectType.SPEED,
                Integer.MAX_VALUE, 0, true), true);
    }

    public ItemStack getIcon() {
        return icon;
    }
}
