package vn.sunnet.lovechallenge.model.player.action;

public interface PlayerActionState {

	/**
	 * hành động vuốt tay lên
	 */
	public void flingup();
	
	/**
	 * Hành động vuốt tay xuống
	 */
	public void flingdown();
	
	/**
	 * hành động va chạm với chướng ngại vật
	 */
	public void collistionImpedimet();
	
	/**
	 * Hành động chuyển sang trạng thái run bình thường
	 */
	public void idleRun(float delta);
	
}
