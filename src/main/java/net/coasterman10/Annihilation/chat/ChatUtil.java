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
package net.coasterman10.Annihilation.chat;

import net.coasterman10.Annihilation.Util;
import net.coasterman10.Annihilation.VaultHooks;
import net.coasterman10.Annihilation.object.Boss;
import net.coasterman10.Annihilation.object.GameTeam;
import net.coasterman10.Annihilation.object.PlayerMeta;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;

public class ChatUtil {
    private static final String DARK_AQUA = ChatColor.DARK_AQUA.toString();
    private static final String DARK_GRAY = ChatColor.DARK_GRAY.toString();
    private static final String DARK_PURPLE = ChatColor.DARK_PURPLE.toString();
    private static final String DARK_RED = ChatColor.DARK_RED.toString();
    private static final String RESET = ChatColor.RESET.toString();
    private static final String GRAY = ChatColor.GRAY.toString();
    private static final String RED = ChatColor.RED.toString();

    private static boolean roman = false;

    public static void setRoman(boolean b) {
        roman = b;
    }

    public static void allMessage(GameTeam team, Player sender, String message,
            boolean dead) {
        String group;
        String username;
        if (team == GameTeam.NONE) {
            group = DARK_GRAY + "[" + DARK_PURPLE + "Lobby" + DARK_GRAY + "]";
            username = RESET + sender.getName();
        } else {
            group = DARK_GRAY + "[" + team.color() + "Global" + DARK_GRAY + "]";
            username = team.color() + sender.getName();
            if (dead) {
                group = DARK_GRAY + "[" + DARK_RED + "MUERTO" + DARK_GRAY + "] "
                        + group;
            }
        }
        String msg = message;
        String permGroup = VaultHooks.getGroup(sender.getName());
        if (!permGroup.equals(""))
            group += " " + permGroup + RESET;
        String toSend = group + " " + username + RESET + ": " + msg;
        for (Player player : Bukkit.getOnlinePlayers())
            player.sendMessage(toSend);
    }

    public static void teamMessage(GameTeam team, Player sender,
            String message, boolean dead) {
        String group;
        if (team == GameTeam.NONE) {
            allMessage(team, sender, message, false);
            return;
        } else {
            group = GRAY + "[" + team.color() + "Equipo" + GRAY + "]";
            if (dead) {
                group = DARK_GRAY + "[" + DARK_RED + "MUERTO" + DARK_GRAY + "] " + group;
            }
        }
        String permGroup = VaultHooks.getGroup(sender.getName());
        if (!permGroup.equals(""))
            group += " " + permGroup + RESET;
        String toSend = group + " " + team.color() + sender.getName() + RESET + ": " + message;
        for (Player player : team.getPlayers())
            player.sendMessage(toSend);
    }

    public static void broadcast(String message) {
        Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&',
                message));
    }

    public static void nexusDestroyed(GameTeam attacker, GameTeam victim,
            Player p) {
        broadcast(GRAY + "===============[ " + victim.color().toString()
                + "Nexo Destruido" + GRAY + " ]===============");
        broadcast(attacker.color().toString() + p.getName() + GRAY + " from "
                + attacker.coloredName() + GRAY + " ha destruido el nexo del equipo "
                + victim.coloredName());
        broadcast(GRAY + "===============================================");
    }

    public static String nexusBreakMessage(Player breaker, GameTeam attacker,
            GameTeam victim) {
        return colorizeName(breaker, attacker) + GRAY + " ha dañado el Nexo del equipo "
                + victim.coloredName();
    }

    private static String colorizeName(Player player, GameTeam team) {
        return team.color() + player.getName();
    }

    public static void phaseMessage(int phase) {
        broadcast(GRAY + "===========[ " + DARK_AQUA + "Progreso" + GRAY
                + " ]===========");
        broadcast(Util.getPhaseColor(phase) + "La Fase " + translateRoman(phase) + GRAY + " ha comenzado");
        switch (phase) {
        case 1:
            broadcast(GRAY + "Los Nexos son indestructibles hasta la fase "
                    + translateRoman(2));
            break;
        case 2:
            broadcast(GRAY + "Los Nexos ya no son indestructibles");
            broadcast(GRAY + "Los Boss Iron Golems apareceran ahora");
            break;
        case 3:
            broadcast(GRAY + "Los diamantes apareceran ahora en el medio");
            break;
        case 4:
            break;
        case 5:
            broadcast(RED + "Daño a los Nexos x2");
        }
        broadcast(GRAY + "================================");
    }

    public static void winMessage(GameTeam winner) {
        broadcast(GRAY + "================[ " + winner.color().toString()
                + "Partida terminada" + GRAY + " ]================");
        broadcast(GRAY + "El equipo " + winner.coloredName() + GRAY
                + " Ha ganado la partida! Reiniciando partida...");
        broadcast(GRAY + "==========================================");
    }

    public static void bossDeath(Boss b, Player killer, GameTeam team) {
        broadcast(GRAY + "==========[ " + DARK_AQUA + "Boss Matado" + GRAY
                + " ]==========");
        broadcast(GRAY + b.getBossName() + GRAY + " ha sido matado por "
                + colorizeName(killer, team));
        broadcast(GRAY + "================================");
    }

    public static void bossRespawn(Boss b) {
        broadcast(GRAY + "================[ " + DARK_AQUA + "Boss" + GRAY
                + " ]================");
        broadcast(GRAY + b.getBossName() + GRAY
                + " ha aparecido! Ve a matarlo!");
        broadcast(GRAY + "=======================================");
    }

    public static String formatDeathMessage(Player victim, Player killer,
            String original) {
        GameTeam killerTeam = PlayerMeta.getMeta(killer).getTeam();
        String killerColor = killerTeam != null ? killerTeam.color().toString()
                : ChatColor.DARK_PURPLE.toString();
        String killerName = killerColor + killer.getName() + ChatColor.GRAY;

        String message = ChatColor.GRAY + formatDeathMessage(victim, original);
        message = message.replace(killer.getName(), killerName);

        return message;
    }

    public static String formatDeathMessage(Player victim, String original) {
        GameTeam victimTeam = PlayerMeta.getMeta(victim).getTeam();
        String victimColor = victimTeam != null ? victimTeam.color().toString()
                : ChatColor.DARK_PURPLE.toString();
        String victimName = victimColor + victim.getName() + ChatColor.GRAY;

        String message = ChatColor.GRAY + original;
        message = message.replace(victim.getName(), victimName);

        if (message.contains(" �8�")) {
            String[] arr = message.split(" �8�");
            message = arr[0];
        }

        return message.replace("ha sido matado por", "ha muerto a manos de");
    }

    public static String translateRoman(int number) {
        if (!roman)
            return String.valueOf(number);

        switch (number) {
        case 0:
            return "0";
        case 1:
            return "I";
        case 2:
            return "II";
        case 3:
            return "III";
        case 4:
            return "IV";
        case 5:
            return "V";
        case 6:
            return "VI";
        case 7:
            return "VII";
        case 8:
            return "VIII";
        case 9:
            return "IX";
        case 10:
            return "X";
        default:
            return String.valueOf(number);
        }
    }
}
