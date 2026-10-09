package at.johannes.skythunder.features.fishing

import at.johannes.skythunder.skyblock.Rarity
import at.johannes.skythunder.skyblock.SeaCreatureCategory

enum class SeaCreature(val creatureName: String, val chatMessage: String, val rarity: Rarity, val category: SeaCreatureCategory) {

    //region Basic
    SQUID("Squid", "A Squid appeared.", Rarity.COMMON, SeaCreatureCategory.BASIC),
    SEA_WALKER("Sea Walker", "You caught a Sea Walker.", Rarity.COMMON, SeaCreatureCategory.BASIC),
    SEA_WITCH("Sea Witch", "It looks like you've disrupted the Sea Witch's brewing session. Watch out, she's furious!", Rarity.UNCOMMON, SeaCreatureCategory.BASIC),
    SEA_ARCHER("Sea Archer", "You reeled in a Sea Archer.", Rarity.UNCOMMON, SeaCreatureCategory.BASIC),
    RIDER_OF_THE_DEEP("Rider of the Deep", "The Rider of the Deep has emerged.", Rarity.UNCOMMON, SeaCreatureCategory.BASIC),
    CATFISH("Catfish", "Huh? A Catfish!", Rarity.RARE, SeaCreatureCategory.BASIC),
    SEA_LEECH("Sea Leech", "Gross! A Sea Leech!", Rarity.RARE, SeaCreatureCategory.BASIC),
    GUARDIAN_DEFENDER("Guardian Defender", "You've discovered a Guardian Defender of the sea.", Rarity.EPIC, SeaCreatureCategory.BASIC),
    DEEP_SEA_PROTECTOR("Deep Sea Protector", "You have awoken the Deep Sea Protector, prepare for a battle!", Rarity.EPIC, SeaCreatureCategory.BASIC),
    WATER_HYDRA("Water Hydra", "The Water Hydra has come to test your strength.", Rarity.LEGENDARY, SeaCreatureCategory.BASIC),
    //endregion

    //region Backwater Bayou
    DUMPSTER_DIVER("Dumpster Diver", "A Dumpster Diver has emerged from the swamp!", Rarity.UNCOMMON, SeaCreatureCategory.BACKWATER_BAYOU),
    TRASH_GOBBLER("Trash Gobbler", "The Trash Gobbler is hungry for you!", Rarity.COMMON, SeaCreatureCategory.BACKWATER_BAYOU),
    BANSHEE("Banshee", "The desolate wail of a Banshee breaks the silence.", Rarity.RARE, SeaCreatureCategory.BACKWATER_BAYOU),
    BAYOU_SLUDGE("Bayou Sludge", "A swampy mass of slime emerges, the Bayou Sludge!", Rarity.EPIC, SeaCreatureCategory.BACKWATER_BAYOU),
    ALLIGATOR("Alligator", "A long snout breaks the surface of the water. It's an Alligator!", Rarity.LEGENDARY, SeaCreatureCategory.BACKWATER_BAYOU),
    TITANOBOA("Titanoboa", "A massive Titanoboa surfaces. It's body stretches as far as the eye can see.", Rarity.MYTHIC, SeaCreatureCategory.BACKWATER_BAYOU),
    //endregion

    //region Lotus Atoll
    ATOLL_CROAKER("Atoll Croaker", "An inquisitive Atoll Croaker takes the bait!", Rarity.COMMON, SeaCreatureCategory.LOTUS_ATOLL),
    PUDDLE_JUMPER("Puddle Jumper", "A Puddle Jumper is preparing for liftoff—cast your rod into it and hold on tight!", Rarity.LEGENDARY, SeaCreatureCategory.LOTUS_ATOLL),
    LOTUS_GUARDIAN("Lotus Guardian", "A Lotus Guardian emerges, ready to protect the Atoll.", Rarity.UNCOMMON, SeaCreatureCategory.LOTUS_ATOLL),
    GORF("gorF", "What even is that?! A... gorF?", Rarity.RARE, SeaCreatureCategory.LOTUS_ATOLL),
    FROG_PRINCE("Frog Prince", "Bow down before the Frog Prince... or pay the hefty price!", Rarity.MYTHIC, SeaCreatureCategory.LOTUS_ATOLL),
    DROWNED_CAPTAIN("Drowned Captain", "A Drowned Captain takes hold of your bobber!", Rarity.EPIC, SeaCreatureCategory.LOTUS_ATOLL),
    //endregion

    // region Moonglade Marsh
    BOGGED("Bogged", "You've hooked a Bogged!", Rarity.COMMON, SeaCreatureCategory.MOONGLADE_MARSH),
    WETWING("Wetwing", "Look! A Wetwing emerges!", Rarity.UNCOMMON, SeaCreatureCategory.MOONGLADE_MARSH),
    TADGANG("Tadgang", "A gang of Liltads!", Rarity.RARE, SeaCreatureCategory.MOONGLADE_MARSH),
    ENT("Ent", "You've hooked an Ent, as ancient as the forest itself.", Rarity.EPIC, SeaCreatureCategory.MOONGLADE_MARSH),
    STRIDERSURFER("Stridersurfer", "You caught a Stridersurfer.", Rarity.RARE, SeaCreatureCategory.MOONGLADE_MARSH),
    THE_LOCH_EMPEROR("The Loch Emperor", "The Loch Emperor arises from the depths.", Rarity.LEGENDARY, SeaCreatureCategory.MOONGLADE_MARSH),
    NESSIE("Nessie", "You've caused a disturbance in the loch. Could it be... Nessie?", Rarity.MYTHIC, SeaCreatureCategory.MOONGLADE_MARSH),
    //endregion

    //region Torrhus Canyon
    HAGGARD("Haggard", "A Haggard stumbles to the shore, ready for a fight!", Rarity.COMMON, SeaCreatureCategory.TORRHUS_CANYON),
    BRINELING("Brineling", "A Brineling interrupts you with a stream of bubbles!", Rarity.UNCOMMON, SeaCreatureCategory.TORRHUS_CANYON),
    SPRAWL("Sprawl", "A Sprawl emerges from the blue, and it's looking for you!", Rarity.RARE, SeaCreatureCategory.TORRHUS_CANYON),
    TORRID("Torrid", "The laughter of a Torrid echoes through the air.", Rarity.EPIC, SeaCreatureCategory.TORRHUS_CANYON),
    SILKBREEZE("Silkbreeze", "Something zips through the air - it's a Silkbreeze!", Rarity.LEGENDARY, SeaCreatureCategory.TORRHUS_CANYON),
    GIANT_ISOPOD("Giant Isopod", "A Giant Isopod was dredged up from the depths!", Rarity.MYTHIC, SeaCreatureCategory.TORRHUS_CANYON),
    //endregion

    //region Crimson Isle
    FRIED_CHICKEN("Fried Chicken", "Smells of burning. Must be a Fried Chicken.", Rarity.COMMON, SeaCreatureCategory.CRIMSON_ISLE),
    VOLCANIC_SNAIL("Volcanic Snail", "You feel a burning sensation as you reel in a Volcanic Snail!", Rarity.UNCOMMON, SeaCreatureCategory.CRIMSON_ISLE),
    FIREPROOF_WITCH("Fireproof Witch", "Trouble's brewing, it's a Fireproof Witch!", Rarity.RARE, SeaCreatureCategory.CRIMSON_ISLE),
    MAGMA_SLUG("Magma Slug", "From beneath the lava appears a Magma Slug.", Rarity.UNCOMMON, SeaCreatureCategory.CRIMSON_ISLE),
    MOOGMA("Moogma", "You hear a faint Moo from the lava... A Moogma appears.", Rarity.UNCOMMON, SeaCreatureCategory.CRIMSON_ISLE),
    LAVA_LEECH("Lava Leech", "A small but fearsome Lava Leech emerges.", Rarity.RARE, SeaCreatureCategory.CRIMSON_ISLE),
    PYROCLASTIC_WORM("Pyroclastic Worm", "You feel the heat radiating as a Pyroclastic Worm surfaces.", Rarity.RARE, SeaCreatureCategory.CRIMSON_ISLE),
    MAGMA_PILLAR("Magma Pillar", "A Magma Pillar rises from the lava.", Rarity.EPIC, SeaCreatureCategory.CRIMSON_ISLE),
    LAVA_FLAME("Lava Flame", "A Lava Flame flies out from beneath the lava.", Rarity.RARE, SeaCreatureCategory.CRIMSON_ISLE),
    FIRE_EEL("Fire Eel", "A Fire Eel slithers out from the depths.", Rarity.RARE, SeaCreatureCategory.CRIMSON_ISLE),
    TAURUS("Taurus", "Taurus and his steed emerge.", Rarity.EPIC, SeaCreatureCategory.CRIMSON_ISLE),
    THUNDER("Thunder", "You hear a massive rumble as Thunder emerges.", Rarity.MYTHIC, SeaCreatureCategory.CRIMSON_ISLE),
    FIERY_SCUTTLER("Fiery Scuttler", "A Fiery Scuttler inconspicuously waddles up to you, friends in tow.", Rarity.LEGENDARY, SeaCreatureCategory.CRIMSON_ISLE),
    LORD_JAWBUS("Lord Jawbus", "You have angered a legendary creature... Lord Jawbus has arrived.", Rarity.MYTHIC, SeaCreatureCategory.CRIMSON_ISLE),
    RAGNAROK("Ragnarok", "The sky darkens and the air thickens. The end times are upon us: Ragnarok is here.", Rarity.MYTHIC, SeaCreatureCategory.CRIMSON_ISLE),
    //endregion

    //region Winter
    FROSTY("Frosty", "It's a snowman! He looks harmless.", Rarity.COMMON, SeaCreatureCategory.WINTER_ISLAND),
    FROZEN_STEVE("Frozen Steve", "Frozen Steve fell into the pond long ago, never to resurface...until now!", Rarity.COMMON, SeaCreatureCategory.WINTER_ISLAND),
    GRINCH("Grinch", "The Grinch stole Jerry's Gifts...get them back!", Rarity.UNCOMMON, SeaCreatureCategory.WINTER_ISLAND),
    YETI("Yeti", "What is this creature!?", Rarity.LEGENDARY, SeaCreatureCategory.WINTER_ISLAND),
    NUTCRACKER("Nutcracker", "You found a forgotten Nutcracker laying beneath the ice.", Rarity.LEGENDARY, SeaCreatureCategory.WINTER_ISLAND),
    REINDRAKE("Reindrake", "A Reindrake forms from the depths.", Rarity.LEGENDARY, SeaCreatureCategory.WINTER_ISLAND),
    //endregion

    //region Spooky
    JUMPIN_JACK("Jumpin' Jack", "Watch out! It's Jumpin' Jack.", Rarity.COMMON, SeaCreatureCategory.SPOOKY),
    SCARECROW("Scarecrow", "Phew! It's only a Scarecrow.", Rarity.COMMON, SeaCreatureCategory.SPOOKY),
    NIGHTMARE("Nightmare", "You hear trotting from beneath the waves, you caught a Nightmare.", Rarity.RARE, SeaCreatureCategory.SPOOKY),
    WEREWOLF("Werewolf", "It must be a full moon, a Werewolf appears.", Rarity.EPIC, SeaCreatureCategory.SPOOKY),
    PHANTOM_FISHER("Phantom Fisher", "The spirit of a long lost Phantom Fisher has come to haunt you.", Rarity.LEGENDARY, SeaCreatureCategory.SPOOKY),
    GRIM_REAPER("Grim Reaper", "This can't be! The manifestation of death himself!", Rarity.LEGENDARY, SeaCreatureCategory.SPOOKY),
    //endregion

    //region Shark
    NURSE_SHARK("Nurse Shark", "A tiny fin emerges from the water, you've caught a Nurse Shark.", Rarity.COMMON, SeaCreatureCategory.SHARK),
    BLUE_SHARK("Blue Shark", "You spot a fin as blue as the water it came from, it's a Blue Shark.", Rarity.UNCOMMON, SeaCreatureCategory.SHARK),
    TIGER_SHARK("Tiger Shark", "A striped beast bounds from the depths, the wild Tiger Shark!", Rarity.EPIC, SeaCreatureCategory.SHARK),
    GREAT_WHITE_SHARK("Great White Shark", "Hide no longer, a Great White Shark has tracked your scent and thirsts for your blood!", Rarity.LEGENDARY, SeaCreatureCategory.SHARK),
    //endregion

    //region Hotspot
    FROG_MAN("Frog Man", "Is it a frog? Is it a man? Well, yes, sorta, IT'S FROG MAN!!!!!!", Rarity.COMMON, SeaCreatureCategory.HOTSPOT),
    INKLING("Inkling", "You get an inkling that you've caught... an Inkling!", Rarity.UNCOMMON, SeaCreatureCategory.HOTSPOT),
    SNAPPING_TURTLE("Snapping Turtle", "A Snapping Turtle is coming your way, and it's ANGRY!", Rarity.RARE, SeaCreatureCategory.HOTSPOT),
    BLUE_RINGED_OCTOPUS("Blue Ringed Octopus", "A garish set of tentacles arise. It's a Blue Ringed Octopus!", Rarity.LEGENDARY, SeaCreatureCategory.HOTSPOT),
    WIKI_TIKI("Wiki Tiki", "The water bubbles and froths. A massive form emerges- you have disturbed the Wiki Tiki! You shall pay the price.", Rarity.MYTHIC, SeaCreatureCategory.HOTSPOT),
    //endregion

    //region Special
    SMALL_MITHRIL_GRUBBER("Small Mithril Grubber", "A leech of the mines surfaces... you've caught a Mithril Grubber.", Rarity.UNCOMMON, SeaCreatureCategory.SPECIAL),
    MEDIUM_MITHRIL_GRUBBER("Medium Mithril Grubber", "A leech of the mines surfaces... you've caught a Medium Mithril Grubber.", Rarity.UNCOMMON, SeaCreatureCategory.SPECIAL),
    LARGE_MITHRIL_GRUBBER("Large Mithril Grubber", "A leech of the mines surfaces... you've caught a Large Mithril Grubber.", Rarity.UNCOMMON, SeaCreatureCategory.SPECIAL),
    BLOATED_MITHRIL_GRUBBER("Bloated Mithril Grubber", "A leech of the mines surfaces... you've caught a Bloated Mithril Grubber.", Rarity.UNCOMMON, SeaCreatureCategory.SPECIAL),
    OASIS_SHEEP("Oasis Sheep", "An Oasis Sheep appears from the water.", Rarity.UNCOMMON, SeaCreatureCategory.SPECIAL),
    OASIS_RABBIT("Oasis Rabbit", "An Oasis Rabbit appears from the water.", Rarity.UNCOMMON, SeaCreatureCategory.SPECIAL),
    CARROT_KING("Carrot King", "Is this even a fish? It's the Carrot King!", Rarity.RARE, SeaCreatureCategory.SPECIAL),
    AGARIMOO("Agarimoo", "Your Chumcap Bucket trembles, it's an Agarimoo.", Rarity.RARE, SeaCreatureCategory.SPECIAL),
    WATER_WORM("Water Worm", "A Water Worm surfaces!", Rarity.RARE, SeaCreatureCategory.SPECIAL),
    POISONED_WATER_WORM("Poisoned Water Worm", "A Poisoned Water Worm surfaces!", Rarity.RARE, SeaCreatureCategory.SPECIAL),
    FLAMING_WORM("Flaming Worm", "A Flaming Worm surfaces from the depths!", Rarity.RARE, SeaCreatureCategory.SPECIAL),
    LAVA_BLAZE("Lava Blaze", "A Lava Blaze has surfaced from the depths!", Rarity.EPIC, SeaCreatureCategory.SPECIAL),
    LAVA_PIGMAN("Lava Pigman", "A Lava Pigman arose from the depths!", Rarity.EPIC, SeaCreatureCategory.SPECIAL),
    ABYSSAL_MINER("Abyssal Miner", "An Abyssal Miner breaks out of the water!", Rarity.LEGENDARY, SeaCreatureCategory.SPECIAL),
    PLHLEGBLAST("Plhlegblast", "WOAH! A Plhlegblast appeared.", Rarity.MYTHIC, SeaCreatureCategory.SPECIAL);
    //endregion
}