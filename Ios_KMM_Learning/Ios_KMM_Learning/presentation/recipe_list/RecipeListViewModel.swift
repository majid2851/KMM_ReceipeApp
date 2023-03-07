
import SwiftUI
import shared

class RecipeListViewModel:ObservableObject
{
    //Dependencies
    let searchRecipes:SearchRecipes
    let foodCategoryUtils:FoodCategoryUtil
    
    @Published var state:RecipeStateList=RecipeStateList()
    
    
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
            doNothing()
            
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
    func loadRecipes()
    {
        let currentState=(self.state.copy() as! RecipeStateList)
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
                        
                        self.updateState(isLoading: loading)
                        
                        if data != nil
                        {
                            self.appendRecipes(recipes:data as![Recipe])
                        }
                        if(message != nil)
                        {
                            self.handleMessageByUiComponentType(message!)
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
            for recipe in recipes{
                print("\(recipe.title)")
            }
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
            queue:Queue<GenericMessageInfo>?=nil
        )
        {
            let currentState:RecipeStateList=self.state.copy() as! RecipeStateList
            self.state=self.state.doCopy(
                isLoading: isLoading ?? currentState.isLoading,
                page: Int32(page ?? Int(currentState.page)),
                query: query ?? currentState.query,
                selectedCategory:currentState.selectedCategory,
                recipe:currentState.recipe,
                queue: queue ?? currentState.queue
            )
            
            
        }

}
