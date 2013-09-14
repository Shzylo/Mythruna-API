println "addShellCommand Method Loaded"

on([playerJoined]) { //We will give the command to the player when they join.
  type, event ->
	//initialize the event

	//this is what the player sees when they type '/help Hello' in singleplayer,
	//'~help Hello' in multiplayer.
	def helloInfo = """\
			Hello Test Command
			Just for a test.
			"""

	/** HOW TO ADD A COMMAND
	 * 
	 * addShellCommand(ShellScript shell, String CommandName, String CommandDescription, String[] CommandHelpInfo)
	 * - (ShellScript shell) - Leave the first parameter as 'shell' so it can add the command.
	 * - (String CommandName) - The name of the command.
	 * - (String CommandDescription) - The description of the command.
	 * - (String[] CommandHelpInfo) - The information a player gets when they type
	 * '/help <command-name>' on single player, and '~help <command-name>' in multiplayer.
	 * if you leave this parameter as 'null' it won't give them help information.
	 */
	addShellCommand(shell, "Hello", "Just a test", helloInfo) {
		// It will tell the player 'Hello World.' when they type the command.
		console.echo("Hello World.")
	}
}
