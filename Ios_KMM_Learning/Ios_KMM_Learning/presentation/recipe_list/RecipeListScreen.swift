
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
        List
        {
            ForEach(viewModel.state.recipe,id:\.self.id)
            {recipe in
                Text(recipe.title).onAppear(perform:{
                    if(viewModel.shouldQueryNextPage(recipe: recipe))
                    {
                        viewModel.onTriggerEvent(stateEvent: RecipeListEvents.nextPage())
                    }
                    
                })
                
                
                
            }
        }
        
        
        
        
    }
}



//struct RecipeListScreen_Previews: PreviewProvider {
//    static var previews: some View {
//        RecipeListScreen()
//    }
//}
