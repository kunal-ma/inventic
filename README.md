<h1 align="center">Inventic</h1>

<p align="center">
A Minecraft mod that lets you open the crafting table without placing it down. I made this mod to avoid the hassle of repeatedly placing and picking up my crafting table while exploring. Supports customizing the hotkey and an optional crafting table requirement.
</p>

## Getting Started

You can download a pre-built JAR from the [Releases](https://github.com/kunal-ma/inventic/releases) section, or build the mod yourself. Since this mod was primarily made for my own modpack, **backports to older Minecraft versions are unlikely**.

> [!WARNING]
> This repository uses separate branches and tags for different Minecraft versions. Make sure to select the branch or tag matching your Minecraft version before downloading or building the mod.

### Building the mod

1. Clone the repository:
   ```bash
   git clone https://github.com/kunal-ma/inventic.git
   cd inventic
   ```

2. Switch to the branch or tag matching your Minecraft version. For example, to use the `1.21.1` branch:
   ```bash
   git switch 1.21.1
   ```

2. Build the mod using Gradle:
   ```bash
   ./gradlew build
   ```
   On Windows, use `./gradlew.bat build` instead.

3. The built JAR will be located in `build/libs/`.

### Usage


1. Place the mod JAR in your Minecraft instance's `mods` folder.
2. Launch Minecraft with the matching Minecraft and NeoForge versions.
3. Press `Z` to open the crafting table interface. You can change the keybind under **Options → Controls → Key Binds → Inventic**.
4. Customize the mod's behavior by editing `config/inventic-common.toml`:

   | Option               | Purpose                                                                                           |
   | -------------------- | ------------------------------------------------------------------------------------------------- |
   | `requireInInv`       | Whether a crafting table must remain in your inventory while the interface is open.               |
   | `craftingTableItems` | Item IDs that can be used to open the crafting interface. Defaults to `minecraft:crafting_table`. |


## Acknowledgements

Distributed under the GNU Affero General Public License v3.0. See <a href="https://github.com/kunal-ma/inventic/blob/main/LICENSE">`LICENSE`</a> for more information.
