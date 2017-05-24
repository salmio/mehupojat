var ProductBox  = React.createClass({
    render:function(){
        return(
            <App/>
        );
    }
});

var App = React.createClass({
    //setting up initial state
    getInitialState:function(){
        return{
            data:[]
        };
    },
    componentDidMount(){
        this.getDataFromServer('http://localhost:8080/products');
    },
    //showResult Method
        showResult: function(response) {

            this.setState({
                data: response
            });
    },
    //making ajax call to get data from server
    getDataFromServer:function(URL){
        $.ajax({
            type:"GET",
            dataType:"json",
            url: URL,
            success: function(response) {
                this.showResult(response);
            }.bind(this),
            error: function(xhr, status, err) {
                console.error(this.props.url, status, err.toString());
            }.bind(this)
        });
    },
    render:function(){
        return(
            <div>
                <Result result={this.state.data}/>
            </div>
        );
    }
});

var Result = React.createClass({
    render:function(){
        var result = this.props.result.map(function(result,index){
            return <ResultItem key={index} user={ result } />
            });
        return(
            <div className="container">
                <div className="row">
                    {result}
                </div>
            </div>
        );
    }
});

var ResultItem = React.createClass({
    decreaseStock: function() {
        var formData = JSON.stringify(1);
        $.ajax({
            type:"POST",
            data:formData,
            url:"/products/" +  this.props.user.id + "/decrease",
            contentType : "application/json"
        });  
    },
    render:function(){
        var camper = this.props.user;
        var productStockStatus;

        switch (camper.stock) {
            case 0:
                productStockStatus = <input type="button" id="graybutton" className="btn btn-lg btn-primary btn-block"
                                        value="Lisää ostoskoriin" />
                break;
            default:
                productStockStatus = 
                                    <input type="button" className="btn btn-lg btn-primary btn-block"
                                        value="Lisää ostoskoriin"  onClick={() => this.decreaseStock()} />
        }

        return(
            <div className="col-xs-6 col-sm-4 col-md-3">
                <div className="product">
                    <div className="col-xs-12"><img src={camper.imageURL} /></div>
                    <div className="col-xs-12"><h3>{camper.name}</h3></div>
                    <div className="col-xs-12" id="tuotekuvaus"><p>{camper.description}</p></div>
                    <div className="col-xs-12"><p id="varasto">Varastossa: {camper.stock}</p> <p id="hinta">€ {camper.price}</p> </div>
                    <form id={"myForm" + camper.id}>
                        <div className="col-xs-12">{productStockStatus}</div>
                    </form>
                </div>
            </div>
        );
    }
});

ReactDOM.render(<ProductBox />, document.getElementById('products'));