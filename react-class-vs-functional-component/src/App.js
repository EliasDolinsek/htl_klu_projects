import './App.css';
import React, {useState} from "react";

function App() {
  return (
    <div className="App">
      <ClassComponent />
      <FunctionalComponent />
    </div>
  );
}

class ClassComponent extends React.Component {
  constructor(props) {
    super(props);
    this.state = {count: 0}
  }

  render() {
    return <div>
      <h1>{this.state.count}</h1>
      <button onClick={() => {
        this.setState({count: this.state.count + 1})
      }}>+</button>
      <button onClick={() => {
        this.setState({count: this.state.count - 1})
      }}>-</button>
    </div>
  }
}

function FunctionalComponent(){
  const [count, setCount] = useState(0)

  return <div>
    <h1>{count}</h1>
    <button onClick={() => {setCount(count + 1)}}>+</button>
    <button onClick={() => {setCount(count - 1)}}>-</button>
  </div>
}

export default App;
