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
package net.coasterman10.Annihilation.commands;

import net.coasterman10.Annihilation.Annihilation;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;

public class AnnihilationCommand implements CommandExecutor {
    private Annihilation plugin;

    public AnnihilationCommand(Annihilation plugin) {
        this.plugin = plugin;
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        String cyan = ChatColor.DARK_AQUA.toString();
        String white = ChatColor.WHITE.toString();
        String gray = ChatColor.GRAY.toString();
        String red = ChatColor.RED.toString();
        String gold = ChatColor.GOLD.toString();
        String yellow = ChatColor.YELLOW.toString();
        String dgray = ChatColor.DARK_GRAY.toString();
        String green = ChatColor.GREEN.toString();
        String prefix = cyan + "[HighLand] " + gray;
        
        if (args.length == 0) {
            sender.sendMessage(prefix + white + "Destruye el Nexo");
            sender.sendMessage(prefix + gold + "Visita nuestra web en");
            sender.sendMessage(prefix + yellow + "http://www.highland-server.com");
            sender.sendMessage(prefix + gray + "Ayuda:");
            sender.sendMessage(prefix + gray + "/anni " + dgray + "-" + white + " Informacion.");
            sender.sendMessage(prefix + gray + "/anni start " + dgray + "-" + white + " Inicia la partida.");
        }
        
        if (args.length == 1) {
            if (args[0].equalsIgnoreCase("start")) {
                if (sender.hasPermission("annihilation.command.start")) {
                    if (!plugin.startTimer()) {
                        sender.sendMessage(prefix + red + "La partida ya ha empezado");
                    } else {
                        sender.sendMessage(prefix + green + "La partida ha sido empezado.");
                    }
                } else sender.sendMessage(prefix + red + "No puedes usar ese comando!");
            }
        }
        return false;
    }
}
