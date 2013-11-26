package vn.sunnet.lovechallenge;

import vn.sunnet.lovechallenge.utils.AnimationSprite;

import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.utils.Array;

public class Resources2 {

	private static Resources2 instance;

	public static Resources2 getInstance() {
		if (instance == null) {
			instance = new Resources2();
		}
		return instance;
	}

	public Resources2() {

	}

	public void loadGameScreen(AssetManager manager1, AssetManager manager2) {
		manager1.load("bg/sky.png", Texture.class);
		manager1.load("bg/road.png", Texture.class);
		manager1.load("bg/house.atlas", TextureAtlas.class);
		manager1.load("bg/bghouse.png", Texture.class);

		manager1.load("player/player.atlas", TextureAtlas.class);

		manager1.load("staticobject/staticobject.atlas", TextureAtlas.class);
	}

	public void unloadGameScreen(AssetManager manager1, AssetManager manager2) {
		manager1.unload("bg/sky.png");
		manager1.unload("bg/road.png");
		manager1.unload("bg/house.atlas");
		manager1.unload("bg/bghouse.png");
		manager1.unload("player/player.atlas");
		manager1.unload("staticobject/staticobject.atlas");
	}

	public Sprite skySprite;
	public Sprite roadSprite;
	public Sprite house1Sprite;
	public Sprite house2Sprite;
	public Sprite house3Sprite;
	public Sprite house4Sprite;
	public Sprite house5Sprite;
	public Sprite house6Sprite;
	public Sprite house7Sprite;
	public Sprite wall1Sprite;
	public Sprite wall2Sprite;
	public Sprite bghouseSprite;

	public AnimationSprite player_run;
	public AnimationSprite player_jump_1;
	public AnimationSprite player_sit;
	public AnimationSprite player_die_jump;
	public AnimationSprite player_die_run;;

	public Sprite car1Sprite;
	public Sprite car2Sprite;
	public Sprite box1Sprite;
	public Sprite box2Sprite;
	public Sprite static1Sprite;
	public Sprite static2Sprite;
	public Sprite static3Sprite;
	public Sprite static4Sprite;

	public void getGameScreen(AssetManager manager1, AssetManager manager2) {
		// ============sky=================
		Texture skyTexture = manager1.get("bg/sky.png");
		skyTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		skySprite = new Sprite(skyTexture);
		// ===========road================
		Texture roadTexture = manager1.get("bg/road.png");
		roadTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		roadSprite = new Sprite(roadTexture);
		// ===========house=================
		TextureAtlas houseAtlas = manager1.get("bg/house.atlas");
		house1Sprite = houseAtlas.createSprite("house1");
		house2Sprite = houseAtlas.createSprite("house2");
		house3Sprite = houseAtlas.createSprite("house3");
		house4Sprite = houseAtlas.createSprite("house4");
		house5Sprite = houseAtlas.createSprite("house5");
		house6Sprite = houseAtlas.createSprite("house6");
		house7Sprite = houseAtlas.createSprite("house7");

		wall1Sprite = houseAtlas.createSprite("wall");
		wall2Sprite = houseAtlas.createSprite("wall-2");

		// ==========housebg=================
		Texture bghouseTexture = manager1.get("bg/bghouse.png");
		bghouseTexture.setFilter(TextureFilter.Linear, TextureFilter.Linear);
		bghouseSprite = new Sprite(bghouseTexture);

		TextureAtlas player = manager1.get("player/player.atlas");
		// run
		Array<Sprite> player_runFrames = player.createSprites("run");
		player_run = new AnimationSprite(0.8f / player_runFrames.size,
				player_runFrames);
		player_run.setPlayMode(AnimationSprite.LOOP);
		// jump1
		Array<Sprite> player_jump_1_frames = player.createSprites("jump_1");
		player_jump_1 = new AnimationSprite((0.51f + 0.51f)
				/ player_jump_1_frames.size, player_jump_1_frames);
		player_jump_1.setPlayMode(AnimationSprite.NORMAL);
		// sit
		Array<Sprite> player_sit_1_frames = player.createSprites("sit");
		player_sit = new AnimationSprite(1f / player_sit_1_frames.size,
				player_sit_1_frames);
		player_sit.setPlayMode(AnimationSprite.NORMAL);
		// die
		Array<Sprite> player_die_jump_frames = player.createSprites("die_jump");
		player_die_jump = new AnimationSprite(1f / player_die_jump_frames.size,
				player_die_jump_frames);
		player_die_jump.setPlayMode(AnimationSprite.NORMAL);
		// die run
		Array<Sprite> player_die_run_frames = player.createSprites("die_run");
		player_die_run = new AnimationSprite(1f / player_die_run_frames.size,
				player_die_run_frames);
		player_die_run.setPlayMode(AnimationSprite.NORMAL);

		// static
		TextureAtlas staticObjects = manager1
				.get("staticobject/staticobject.atlas");
		car1Sprite = staticObjects.createSprite("o-to");
		car2Sprite = staticObjects.createSprite("o-to-2");
		box1Sprite = staticObjects.createSprite("box-1");
		box2Sprite = staticObjects.createSprite("box-2");
		static1Sprite = staticObjects.createSprite("vc-1");
		static2Sprite = staticObjects.createSprite("vc-2");
		static3Sprite = staticObjects.createSprite("vc-4");
		static4Sprite = staticObjects.createSprite("vc-5");
	}

}
