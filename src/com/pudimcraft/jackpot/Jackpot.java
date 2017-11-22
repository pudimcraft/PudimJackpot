package com.pudimcraft.jackpot;

import org.bukkit.Bukkit;
import org.bukkit.Server;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.Plugin;
import org.bukkit.plugin.java.JavaPlugin;

import com.vk2gpz.tokenenchant.TokenEnchant;

import net.md_5.bungee.api.ChatColor;

public class Jackpot extends JavaPlugin {
	public void onEnable() {
		Server server = getServer();
		ConsoleCommandSender console = server.getConsoleSender();
		console.sendMessage(ChatColor.AQUA + getDescription().getName() + " V" + getDescription().getVersion() + " ativado!");
		this.saveDefaultConfig();
	}

	public void onDisable() {
		Server server = getServer();
		ConsoleCommandSender console = server.getConsoleSender();
		console.sendMessage(ChatColor.AQUA + getDescription().getName() + " V" + getDescription().getVersion() + " desativado!");
	}
	public TokenEnchant getTokenEnchant() {
		Plugin plugin = Bukkit.getServer().getPluginManager().getPlugin("TokenEnchant");
		if ((plugin == null) || (!(plugin instanceof TokenEnchant))) {
			return null;
		}
		return (TokenEnchant) plugin;
	}
	//ashdasuhdsuahdasuhdas
	public double getValorEmTokens(ItemStack i) {
		short durabilidade = (short) (i.getType().getMaxDurability() - 1);
		i.setDurability(durabilidade);
		TokenEnchant te = getTokenEnchant();
		double itemValue = te.calcRepairCost(i);
		i.setDurability((short) 0);
		return itemValue;
	}
}
