public abstract class FantasyCharacter implements Fighter {
    //Имя персонажа
    private String name;
    //Статы персонажа
    private int healthPoints;
    private int strength;
    private int dexterity;
    //Опыт, золото и уровень
    private int xp;
    private int gold;
    private int level;

    //Конструктор
    public FantasyCharacter(String name, int healthPoints, int strength, int dexterity, int xp, int gold, int level) {
        this.name = name;
        this.healthPoints = healthPoints;
        this.strength = strength;
        this.dexterity = dexterity;
        this.xp = xp;
        this.gold = gold;
        this.level = level;
    }

    //Метод для ведения боя
    @Override
    public int attack() {
        if (dexterity * 3 > getRandomValue()) return strength;
        else return 0;
    }

    public String getName() {
        return name;
    }

    public void addXp(int xpGained) {
        this.xp += xpGained;
        //Рассчитываем новый уровень на основе общего опыта
        int newLevel = this.xp / 100;
        // Проверяем, повысился ли уровень
        if (newLevel > this.level) {
            this.level = newLevel;
            System.out.println(this.name + " достиг уровня " + this.level + "!");
        }
    }

    //Геттеры и сеттеры
    public void setName(String name) {
        this.name = name;
    }

    public int getHealthPoints() {
        return healthPoints;
    }

    public void setHealthPoints(int healthPoints) {
        this.healthPoints = healthPoints;
    }

    public int getStrength() {
        return strength;
    }

    public void setStrength(int strength) {
        this.strength = strength;
    }

    public int getDexterity() {
        return dexterity;
    }

    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    public int getXp() {
        return xp;
    }

    public void setXp(int xp) {
        this.xp = xp;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

    private int getRandomValue() {
        return (int) (Math.random() * 100);
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    //Переопределяем вывод в консоль, чтобы выводилось имя и очки здоровья
    @Override
    public String toString() {
        return String.format("%s здоровье:%d", name, healthPoints);
    }
}