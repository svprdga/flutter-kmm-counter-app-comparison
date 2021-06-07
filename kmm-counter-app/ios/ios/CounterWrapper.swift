import Foundation
import shared

class CounterWrapper : ObservableObject {
    
    // Vars
    
    let viewModel: CounterViewModel = CounterViewModel()
    @Published var model: CounterModel
    
    // Constructors
    
    init() {
        self.model = viewModel.getDefaultState()
        viewModel.onChange { newModel in
            self.model = newModel
        }
    }
}

