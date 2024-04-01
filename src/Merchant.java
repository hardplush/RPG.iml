public class Merchant implements Seller {
    public int buyPotion(FantasyCharacter character) {
        int potionCost = 10; // Стоимость зелья
        int healAmount = 30; // Количество восстанавливаемых очков здоровья
        if (character.getHealthPoints() >= 100 && character.getGold() >= potionCost) {
            System.out.println("Здоровье на максимуме. Зелье не требуется.");
            return 0;
        } else if (character.getGold() >= potionCost) {
            character.setGold(character.getGold() - potionCost);
            int newHealth = Math.min(character.getHealthPoints() + healAmount, 100);
            // Реальное количество восстановленного здоровья
            int actualHealAmount = newHealth - character.getHealthPoints();
            character.setHealthPoints(newHealth);
            return actualHealAmount;
        }
        System.out.println("Недостаточно золота для покупки зелья. Стоимость зелья: 10 золотых");
        return 0;
    }

    //Метод для продажи
    @Override
    public String sell(Goods goods) {
        String result = "";
        if (goods == Goods.POTION) {
            result = "potion";
        }
        return result;
    }

    //enum для товаров
    public enum Goods {
        POTION
    }
}