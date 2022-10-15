package fr.modeetratheure.moviemanager.display;

public enum Scenes{
    MAIN_SCENE("scenes/main-scene.fxml", 1080, 480),
    MOVIES_FOLDER_PICKER_SCENE("scenes/pick-movies-folder.fxml", 540, 240);

    private String name;
    private float width;
    private float height;

    Scenes(String name, float width, float height){
        this.name = name;
        this.width = width;
        this.height = height;
    }

    public String getName(){
        return this.name;
    }

    public float getWidth(){
        return this.width;
    }

    public float getHeight() {
        return this.height;
    }
}

