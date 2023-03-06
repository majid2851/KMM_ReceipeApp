import SwiftUI

@main
struct iOSApp: App
{
    private val networkModule=NetworkModule()
    
	var body: some Scene
    {
		WindowGroup {
			ContentView()
		}
	}
}
