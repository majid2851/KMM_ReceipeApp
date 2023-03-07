import SwiftUI
import shared

@main
struct iOSApp: App
{
    private let networkModule=NetworkModule()
    
    
	var body: some Scene
    {
		WindowGroup {
			RecipeListScreen(networkModule: networkModule)
		}
	}
}
