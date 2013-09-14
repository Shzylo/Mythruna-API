// You NEED to import these to use the action.
// Otherwise, it bugs out, and doesn't work.
import mythruna.script.ActionType
import mythruna.script.ToolActions

println "action Example Loaded"
/**
 * - group:(String groupName) - makes a new category for the tool, specify the name with
 * a string
 * - name:(String toolName) - names the current tool of that category, with a string.
 * - type:ActionType.(Type) - gets what calls the action.
 */
action(group:"Information Grabber", name:"Block Information", type:ActionType.Block) {
  def loc = it.getBlock() // get the clicked block.
	type = world.getType(loc.x, loc.y, loc.z, null) // get the location of the clicked block

	//tells us info about it when we click a block
	console.echo("Block Type: " + type + ", Location: " + loc)	
}

on([playerJoined]) { //this will add the action command to the player when they join.
	type, event -> // lets register this event..

	def refs = [] //an arraylist to store all actions.

	//Just in case, the player already has other tools,
	//lets take the current tools they have, so we don't lose them.
	ToolActions existing = player[ToolActions.class]

	//adds our action to the arraylist 'refs', with the category name, and the tool name.
	refs += actions.getRef("Information Grabber", "Block Information")

	//Now we give it to the player!
	player << new ToolActions(refs, existing)	
}
