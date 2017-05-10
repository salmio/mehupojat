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
    render:function(){
        var camper = this.props.user;
        var productStockStatus;

        switch (camper.stock) {
            case 0:
                productStockStatus = ""
                break;
            default:
                productStockStatus = 
                                    <button className="btn btn-lg btn-primary btn-block" type="submit">
                                    Lisää ostoskoriin</button>

        }

        return(
            <div className="col-xs-6 col-sm-4 col-md-3">
                <div className="product">
                    <div className="col-xs-12"><h3>{camper.name}</h3></div>
                    <div className="col-xs-12"><img src={camper.imageURL} /></div>
                    <div className="col-xs-12"><h4 id="otsikko">Hinta:&nbsp;</h4> <p>{camper.price} €</p></div>
                    <div className="col-xs-12"><h4 id="otsikko">Kuvaus:&nbsp;</h4> <p>{camper.description}</p></div>
                    <div className="col-xs-12"><h4 id="otsikko">Brändi:&nbsp;</h4> <p>{camper.brand.name}</p></div>
                    <div className="col-xs-12"><h4 id="otsikko">Varastossa:&nbsp;</h4> <p>{camper.stock}</p></div>
                    <form method="GET" action={"products/" + camper.id + "/decrease"}>
                        <div className="col-xs-12">{productStockStatus}</div>
                    </form>
                </div>
            </div>
        );
    }
});

ReactDOM.render(<ProductBox />, document.getElementById('products'));