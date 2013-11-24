package vn.sunnet.lovechallenge.model.player.state;

public interface PlayerState {

	/**
	 * va chạm với chướng ngại vật
	 */
	public void collistionImpediment(int type);
	
	/**
	 * thanh trạng thái lên 90%
	 */
	public void increaseStateBar90();
	
	/**
	 * thanh trạng thái lên 80%
	 */
	public void increaseStateBar80();
	
	/**
	 * thanh trạng thái lên 70%
	 */
	public void increaseStateBar70();
	
}
