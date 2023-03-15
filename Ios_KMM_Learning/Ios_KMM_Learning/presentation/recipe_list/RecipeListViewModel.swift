
import SwiftUI
import shared

class RecipeListViewModel:ObservableObject
{
    //Dependencies
    let searchRecipes:SearchRecipes
    let foodCategoryUtils:FoodCategoryUtil
    
    @Published var state:RecipeListState=RecipeListState()
    
    
    init(
        searchRecipes:SearchRecipes,
        foodCategoryUtil:FoodCategoryUtil
    )
    {
        self.searchRecipes=searchRecipes
        self.foodCategoryUtils=foodCategoryUtil
        onTriggerEvent(stateEvent: RecipeListEvents.LoadRecipes())
        
    }
    
    func onTriggerEvent(stateEvent:RecipeListEvents)
    {
        switch stateEvent
        {
        case is RecipeListEvents.LoadRecipes:
            loadRecipes()
            
        case is RecipeListEvents.newSearch:
            doNothing()
            
        case is RecipeListEvents.nextPage:
            nextPage()
            
        case is RecipeListEvents.onUpdateQuery:
            doNothing()
        case is RecipeListEvents.onSelectCategory:
            doNothing()
            
        case is RecipeListEvents.OnRemoveHeadMessageFromQueue:
            doNothing()
        default:
            doNothing()
            
        }
    }
    
    private func nextPage()
    {
        let currentState=self.state.copy() as! RecipeListState
        updateState(page:Int(currentState.page) + 1)
        loadRecipes()
    }
    
    func loadRecipes()
    {
        let currentState=(self.state.copy() as! RecipeListState)
        do{
            try searchRecipes.excute(
                page:Int32(currentState.page),
                query:currentState.query
            ).collectCommon(
                coroutineScope: nil,
                callBack:{dataState in
                    if(dataState != nil)
                    {
                        let data=dataState?.data
                        let message=dataState?.message
                        let loading=dataState?.isLoading ?? false
                        
                        self.updateState(isLoading : loading)
                        
                        print(data)
                        
                        if (data != nil)
                        {
                            self.appendRecipes(recipes:data as![Recipe])
                            print(data)
                        }
                        if(message != nil)
                        {
                            self.handleMessageByUiComponentType(message!)
                            print(message?.description_)
                        }
                        
                    }
                })
            print("mag2851")
            
        }catch{
            print("\(error)")
        }
    }

        
        func appendRecipes(recipes:[Recipe])
        {
            var currentState=(self.state.copy as! RecipeListState)
            var currentRecipes=currentState.recipe
            currentRecipes.append(contentsOf: recipes)
            self.state=self.state.doCopy(isLoading: currentState.isLoading,
                                         page: currentState.page,
                                         query: currentState.query,
                                         selectedCategory: currentState.selectedCategory,
                                         recipe: currentRecipes,
                                         bottomRecipe:currentState.bottomRecipe,
                                         queue: currentState.queue)
            currentState=self.state.copy() as! RecipeListState
            self.onUpdateBottomRecipe(recipe:currentState.recipe[currentState.recipe.count-1])
            
            
            
        }
    
        private func onUpdateBottomRecipe(recipe:Recipe)
        {
            updateState(bottomRecipe: recipe)
            
            
        }
        func shouldQueryNextPage(recipe:Recipe) ->Bool
        {
            //check if looking at bottom recipe
            //if looking at bottom proceed
            //if PAGE_SIZE*page <=recipes.length
            //if !isLoading
            //else ->do Nothing
            let currentState=self.state.copy() as! RecipeListState
            if(recipe.id==currentState.bottomRecipe?.id)
            {
                if(RecipeListState.Companion().RECIPE_PAGINATION_PAGE_SIZE * currentState.page<=currentState.recipe.count)
                {
                    if(!currentState.isLoading)
                    {
                        return true
                    }
                }
            }
            return false
            
            
        }
        
    
        func handleMessageByUiComponentType(
            _ message:GenericMessageInfo)
        {
            
        }
        
        func doNothing()
        {
            
        }
        
        
        func updateState(
            isLoading:Bool?=nil,
            page:Int?=nil,
            query:String?=nil,
            bottomRecipe:Recipe?=nil,
            queue:Queue<GenericMessageInfo>?=nil
        )
        {
            let currentState:RecipeListState=self.state.copy() as! RecipeListState
            self.state=self.state.doCopy(
                isLoading: isLoading ?? currentState.isLoading,
                page: Int32(page ?? Int(currentState.page)),
                query: query ?? currentState.query,
                selectedCategory:currentState.selectedCategory,
                recipe:currentState.recipe,
                bottomRecipe:bottomRecipe ?? currentState.bottomRecipe,
                queue: queue ?? currentState.queue
            )
            
            
            
        }

}
