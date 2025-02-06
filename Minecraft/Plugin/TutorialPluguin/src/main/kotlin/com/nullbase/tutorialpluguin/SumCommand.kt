package com.nullbase.tutorialpluguin

import org.bukkit.command.Command
import org.bukkit.command.CommandExecutor
import org.bukkit.command.CommandSender

object SumCommand : CommandExecutor {
    override fun onCommand(sender: CommandSender, command: Command, label: String, args: Array<out String>): Boolean {
        if (args.size < 2) {
            sender.sendMessage("コマンドの利用方法が間違っています｡")
            return false
        }
        val num1 = args[0].toInt()
        val num2 = args[1].toInt()
        val sum = num1 + num2
        sender.sendMessage("$num1 + $num2 = $sum")
        return true
    }
}