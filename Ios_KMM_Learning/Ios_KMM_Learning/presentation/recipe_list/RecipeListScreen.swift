
import SwiftUI
import shared


struct RecipeListScreen: View
{
    @ObservedObject var viewModel:RecipeListViewModel
    private let networkModule:NetworkModule
    private let searchRecipeModuel:SearchRecipeModule
    
    init(networkModule:NetworkModule)
    {
        self.networkModule=networkModule
        self.searchRecipeModuel=SearchRecipeModule(networkModule:self.networkModule)
        self.viewModel=RecipeListViewModel(
            searchRecipes: searchRecipeModuel.searchRecipes,
            foodCategoryUtil:FoodCategoryUtil()
        )
        
        
    }

    
    var body: some View
    {
        VStack//Column in jetpack
        {
            Text("\(viewModel.state.page)")
            Button(
                action:{
                    viewModel.updateState(page:Int(viewModel.state.page)+1)
                },
                label:{
                    Text("Increment Page")
                }
            )
        
            
        }
        
        
        
        
    }
}



//struct RecipeListScreen_Previews: PreviewProvider {
//    static var previews: some View {
//        RecipeListScreen()
//    }
//}
