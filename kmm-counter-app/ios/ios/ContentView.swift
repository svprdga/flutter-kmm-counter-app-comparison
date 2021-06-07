import SwiftUI
import shared

struct ContentView: View {
    @StateObject var wrapper = CounterWrapper()
    
    var body: some View {
        NavigationView {
            VStack(alignment: /*@START_MENU_TOKEN@*/.center/*@END_MENU_TOKEN@*/) {
                Text("You have pushed the button this many times:")
                Text("\(wrapper.model.count)")
                Button("Increment") {
                    wrapper.viewModel.incrementCount(amount: 1)
                }.padding(.top, 100)
            }
            .navigationBarTitleDisplayMode(.inline)
            .toolbar { // <2>
                ToolbarItem(placement: .principal) { // <3>
                    VStack {
                        Text("KMM version - iOS").font(.headline)
                    }
                }
            }
        }
    }
}

//struct ContentView_Previews: PreviewProvider {
//	static var previews: some View {
//	ContentView()
//	}
//}
