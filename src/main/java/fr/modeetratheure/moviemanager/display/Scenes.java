package fr.modeetratheure.moviemanager.display;

public enum Scenes{
    MAIN_SCENE("scenes/main-scene.fxml", 1080, 480, false),
    MOVIES_FOLDER_PICKER_SCENE("scenes/pick-movies-folder.fxml", 270, 120, true);

    private String name;
    private float width;
    private float height;
    private boolean dimensionsAreMaxSize;

    Scenes(String name, float width, float height, boolean dimensionsAreMaxSize){
        this.name = name;
        this.width = width;
        this.height = height;
        this.dimensionsAreMaxSize = dimensionsAreMaxSize;
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

    public boolean getIfDimensionsAreMaxSize(){
        return this.dimensionsAreMaxSize;
    }
}

