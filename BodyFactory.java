import java.awt.Point;

public class BodyFactory {
	Point position; // Posição da fábrica
	Body [] inventory; // Estoque da fábrica
	
	/**
	 * Cria uma nova fábrica
	 */
	public BodyFactory()
	{
		this.position = Positions.getBodyFactoryPosition();
		this.inventory = new Body[Constants.bodyInventoryLenght];
		for(int i = 0; i < inventory.length; i++)
			inventory[i] = null;
	}
	
	/**
	 * Faz um pedido de um tipo específico de carcaça
	 * @param type tipo da carcaça
	 */
	public void newRequest(int type)
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] == null) inventory[i] = new Body(type, this.getInventoryPositon(i));
	}
	
	/**
	 * Se a fábrica tem, no inventário um dado tipo da carcaça
	 * @param type Tipo de carcaça
	 * @return Retorna true se tem a carcaça ou false caso contrário
	 */
	public boolean hasABody(int type)
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] != null) 
				if(inventory[i].getType() == type) return true;
		return false;
	}
	
	/**
	 * Retira uma carcaça da fábrica (retorna null se não tiver daquele tipo)
	 * @param type Tipo da carcaça desejada
	 * @return Carcaça do tipo desejado, se existente; null caso contrário
	 */
	public Body takeProduct(int type)
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] != null) 
				if(inventory[i].getType() == type)
				{
					Body body = inventory[i];
					inventory[i] = null;
					return body;
				}
		return null;
	}
	
	
	/**
	 * Retorna a posição no cenário de um dado local do inventário
	 * @param i posição no inventário
	 * @return Retorna a posição no cenário de um dado local do inventário
	 */
	Point getInventoryPositon(int i)
	{
		return new Point(this.position.x, this.position.y + i * 3);
	}
	
	/**
	 * Atualiza peças no inventário
	 */
	public void Update()
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] != null) inventory[i].Update();
	}
	
	/**
	 * Imprime peças no inventário
	 * @param draw Imprime peças no inventário
	 */
	public void Draw(Draw draw)
	{
		for(int i = 0; i < inventory.length; i++)
			if(inventory[i] != null) inventory[i].Draw(draw);
	}
}
