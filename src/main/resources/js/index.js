import React from 'react';
import ReactDOM from 'react-dom';
import axios from 'axios';

class Card extends React.Component {
    constructor(props) {
        super(props);
        this.state = {price: null};
    }

    componentDidMount() {
        axios.get('/Cotizacion/' + this.props.currency)
            .then((response) => {
                this.setState({price: response.data.buyPrice});
            })
            .catch(function (error) {
                console.log(error);
            });
    }

    render() {
        return (
            <div className="card">
                <div className="card-block">
                    <h4 className="card-title titulo">{this.props.currency}</h4>
                    <p className="card-text texto">{this.state.price}</p>
                </div>
            </div>
        );
    }
}

class CardContainer extends React.Component {
    render() {
        return (
            <div className="row">
                <div className="col-md-2">
                    <Card currency={'Dolar'}/>
                </div>
                <div className="col-md-2">
                    <Card currency={'Euro'}/>
                </div>
                <div className="col-md-2">
                    <Card currency={'Pesos'}/>
                </div>
            </div>
        );
    }
}

ReactDOM.render(
    <CardContainer/>,
    document.getElementById('root')
);